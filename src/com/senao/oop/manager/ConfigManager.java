package com.senao.oop.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senao.oop.bean.Config;

public class ConfigManager extends BaseManager {

	// 提供 List 存放多筆 Config 物件
	List<Config> configs = new ArrayList<Config>();
	
	/**
	 * 將 config.json 轉成 List<Config>
	 * @param configFilePath
	 * @throws IOException 
	 */
	public void ProcessConfigs(String configFilePath) throws IOException {
		Gson gson = new Gson();
		
		String jsonStr = readTxtFile(configFilePath);
		configs.addAll(((ConfigManager)gson.fromJson(jsonStr, new TypeToken<ConfigManager>(){}.getType())).getConfigs());
	}

	public List<Config> getConfigs() {
		return configs;
	}
	
	/**
	 * 提供 List 的 筆數
	 * @return
	 */
	public int Count() {
		return configs.size();
	}
}
