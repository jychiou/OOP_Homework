package com.senao.oop.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senao.oop.bean.Config;

public class ConfigManager extends JsonManager {

	private static String jsonFilePath = "D:/014616/workspace/_Support/OOP_Homework/dist/config.json";

	// 提供 List<Config> 存放多筆 Config 物件
	private List<Config> configs = new ArrayList<Config>();

	/**
	 * 取得設定清單
	 * 
	 * @return
	 */
	public List<Config> getConfigs() {
		return configs;
	}

	@Override
	public void processJsonConfig() throws IOException {
		configs.addAll(((ConfigManager)getJsonObject(jsonFilePath, ConfigManager.class)).getConfigs());
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		
		strBuff.append("--------------- Configs -----------------\n");
		
		for(int i=0; i<configs.size(); i++) {
			strBuff.append(configs.get(i).toString());
			strBuff.append("-----------------------------------------\n");
		}

		return strBuff.toString();
	}
}
