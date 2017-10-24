package com.senao.oop.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class BaseManager {

	/**
	 * 讀取文字檔
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	protected String readTxtFile(String filePath) throws IOException {
		StringBuffer s = new StringBuffer();
		FileReader fileReader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fileReader);
		
		String line = null;
		
		// 逐行讀取
		while ((line = br.readLine()) != null) {
			s.append(line);
		}
		
		br.close();
		return s.toString();
	}
}
