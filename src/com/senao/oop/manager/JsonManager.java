package com.senao.oop.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public abstract class JsonManager {

	/**
	 * 讀取文字檔
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String readTxtFile(String filePath) throws IOException {
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
	
	/**
	 * 讀取json檔成一個Object
	 * @param jsonFilePath
	 * @param type
	 * @return
	 * @throws IOException
	 */
	protected Object getJsonObject(String jsonFilePath, Type type) throws IOException {
		Gson gson = new Gson();
		String jsonStr = readTxtFile(jsonFilePath);

		return gson.fromJson(jsonStr, type);
	}
	
	/**
	 * 讀取 json 檔
	 * @throws IOException
	 */
	public abstract void processJsonConfig() throws IOException;
}
