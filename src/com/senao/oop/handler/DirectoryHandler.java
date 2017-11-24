package com.senao.oop.handler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.senao.oop.candidate.Candidate;

/**
 * 處理方式 - 儲存到其他目錄
 * @author 014616
 *
 */
public class DirectoryHandler extends AbstractHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("DirectoryHandler.perform() 處理方式 - 儲存到其他目錄");
		
		byte[] result = target;
		
		super.perform(candidate, target);
		
		if (target != null)
			result = this.copyToDirectory(candidate, target);
		
		return result;
	}
	
	/**
	 * 將 byte[] 還原成檔案，並複製到其他目錄
	 * @param candidate
	 * @param target
	 * @return
	 * @throws Exception 
	 */
	private byte[] copyToDirectory(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("DirectoryHandler.copyToDirectory()\r\t=> 將 byte[] 還原成檔案，並複製到其他目錄\t(" + candidate.getConfig().getDir() + ")");
		
		// 檢查目的資料夾是否存在，不存在就建立
		File foler = new File(candidate.getConfig().getDir());
		if(!foler.exists())
			foler.mkdirs();
		
		byte[] result = target;
		
		File sourceFile = new File(candidate.getName());
		
		String name = sourceFile.getName();
		
		Files.write(Paths.get(candidate.getConfig().getDir() + File.separator + name), target);
		
		return result;
	}
}
