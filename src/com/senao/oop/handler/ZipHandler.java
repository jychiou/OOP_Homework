package com.senao.oop.handler;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.senao.oop.candidate.Candidate;

/**
 * 處理方式 - 壓縮
 * @author 014616
 *
 */
public class ZipHandler extends AbstractHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("ZipHandler.perform() 處理方式 - 壓縮");
		
		byte[] result = target;
		
		super.perform(candidate, target);
		
		if (target != null)
			result = this.zipData(candidate, target);
		
		return result;
	}
	
	/**
	 * 將 byte[] 壓縮後回傳 byte[]
	 * @param candidate
	 * @param target
	 * @return
	 * @throws Exception
	 */
	private byte[] zipData(Candidate candidate, byte[] target) throws Exception {
		byte[] result = target;
		
		String name = candidate.getName();
		
		if(name.contains("/"))
			name = name.substring(name.lastIndexOf("/")+1);
		
		if(name.contains("\\"))
			name = name.substring(name.lastIndexOf("\\")+1);
		
		System.out.println("ZipHandler.zipData() ...\r\t=> 將 byte[] 壓縮後回傳 byte[]\t(" + name + ")");
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream zOut = new ZipOutputStream(bos);
		
		// 設定壓縮的程度0~9
		zOut.setLevel(4);
		
		zOut.putNextEntry(new ZipEntry(name));
		zOut.write(target);
		zOut.closeEntry();
		zOut.close();
		result = bos.toByteArray();
		
		return result;
	}
}
