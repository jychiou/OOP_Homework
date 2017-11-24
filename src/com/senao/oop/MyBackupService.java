package com.senao.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senao.oop.manager.ConfigManager;
import com.senao.oop.manager.JsonManager;
import com.senao.oop.manager.ScheduleManager;
import com.senao.oop.task.TaskDispatcher;


/**
 * 只使用 MyBackupService 單一 class 即可處理所有需求
 * 只呼叫 ProcessJSONConfig() 單一 method 即可讀取 config.json 與 schedule.json
 * 繼續呼叫 MyBackupService 的 DoBackup() 即可執行備份
 * @author 014616
 *
 */
public class MyBackupService {

	private List<JsonManager> managers = new ArrayList<JsonManager>();
	ConfigManager configManager = new ConfigManager();
	ScheduleManager scheduleManager = new ScheduleManager();
	
	private TaskDispatcher taskDispatcher;
	
	public MyBackupService() throws Exception {

		// 在建構式中將要執行的 Manager 加入
		managers.add(configManager);
		managers.add(scheduleManager);
		// TODO 新的 Manager 加在這
		
		taskDispatcher = new TaskDispatcher();
		
		init();
	}

	/**
	 * 初始化
	 * @throws Exception
	 */
	private void init() throws Exception {
		processJsonConfigs();
	}
	
	/**
	 * 簡單備份
	 * @throws IOException
	 */
	public void simpleBackup() throws Exception {
		
		// 處理 簡單備份，將 managers 傳入 TaskDispatcher.SimpleTask() 。
		taskDispatcher.simpleTask(managers);
	}
	
	/**
	 * 排程備份
	 * @throws Exception
	 */
	public void scheduledBackup() throws Exception {
		
		// 處理 排程備份，將 managers 傳入 TaskDispatcher.ScheduledTask()
		taskDispatcher.scheduledTask(managers);
	}
	
	private void processJsonConfigs() throws Exception {
		
		// 讀取所有 Manager 的 json 檔案
		for(int i=0; i<managers.size(); i++) {
			managers.get(i).processJsonConfig();
			
			// 印出json內容
			//System.out.println(managers.get(i));
		}
	}
}
