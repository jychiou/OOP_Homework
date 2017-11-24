package com.senao.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senao.oop.manager.ConfigManager;
import com.senao.oop.manager.JsonManager;
import com.senao.oop.manager.ScheduleManager;


/**
 * 只使用 MyBackupService 單一 class 即可處理所有需求
 * 只呼叫 ProcessJSONConfig() 單一 method 即可讀取 config.json 與 schedule.json
 * 繼續呼叫 MyBackupService 的 DoBackup() 即可執行備份
 * @author 014616
 *
 */
public class MyBackupService {

	private List<JsonManager> managers = new ArrayList<JsonManager>();
	
	/**
	 * 在建構式中將要執行的 Manager 加入
	 */
	public void processJSONConfig() {
		managers.add(new ConfigManager());
		managers.add(new ScheduleManager());
		
		// TODO 新的 Manager 加在這
	}
	
	/**
	 * 執行備份
	 * @throws IOException
	 */
	public void doBackup() throws IOException {
		
		// 讀取所有 Manager 的 json 檔案
		for(int i=0; i<managers.size(); i++) {
			managers.get(i).processJsonConfig();
			
			// 印出json內容
			System.out.println(managers.get(i));
		}
		
		// TODO 後續工作...
	}
}
