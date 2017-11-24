package com.senao.oop.handler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.senao.oop.candidate.Candidate;

/**
 * 將檔案轉成 byte[]，或將 byte[] 轉成檔案
 * @author 014616
 *
 */
public class FileHandler extends AbstractHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("FileHandler.perform() 處理方式 - 檔案讀寫");
		
		byte[] result = target;
		
		super.perform(candidate, target);
		
		if(target==null)
			result = this.convertFileToByteArray(candidate);
		else
			this.convertByteArrayToFile(candidate, target);
		
		return result;
	}
	
	/**
	 * 將檔案轉成 byte[]
	 * @param candidate
	 * @return
	 * @throws Exception
	 */
	private byte[] convertFileToByteArray(Candidate candidate) throws Exception	{
		
		System.out.println("FileHandler.convertFileToByteArray()\r\t=> 將檔案轉成 byte[]\t(" + candidate.getName() + ")");
		
		Path path = Paths.get(candidate.getName());
		byte[] target = Files.readAllBytes(path);
			
		return target;
	}
	
	/**
	 * 將 byte[] 轉成檔案
	 * @param candidate
	 * @param target
	 * @throws Exception 
	 */
	private void convertByteArrayToFile(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("FileHandler.convertByteArrayToFile()\r\t=> 將 byte[] 轉成檔案 ");
		
		Path path = Paths.get(candidate.getName());
		Files.write(path, target);
	}
}
