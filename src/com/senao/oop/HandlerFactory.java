package com.senao.oop;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Map;

import com.google.gson.Gson;
import com.senao.oop.handler.Handler;
import com.senao.oop.manager.JsonManager;

/**
 * 負責 new handler
 * @author 014616
 *
 */
public class HandlerFactory {

	private static String jsonFilePath = "D:/014616/workspace/_Support/OOP_Homework/dist/handler_mapping.json";
	
	private static Map<String, String> handlerDictionary;
	
	static
	{
		try {
			Gson gson = new Gson();
			String jsonStr = JsonManager.readTxtFile(jsonFilePath);
			handlerDictionary = gson.fromJson(jsonStr, Map.class);
			
			// 秀出 handler_mapping.json 讀到的內容
			for(String key : handlerDictionary.keySet()) {
				System.out.println(key + " => " + handlerDictionary.get(key));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 建立 Handler 物件
	 * @param handler
	 * @return
	 * @throws Exception 
	 */
	public static Handler create(String handler) throws Exception
	{
		Handler handlerObj = null;
		
		String className = handlerDictionary.get(handler);
		
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor();
		Object object = ctor.newInstance(new Object[] {});
		
		handlerObj = (Handler)object;
		
		System.out.println("生成物件... " + handlerObj);
		
		return handlerObj;
	}
}
