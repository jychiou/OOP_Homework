package com.senao.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senao.oop.bean.Candidate;
import com.senao.oop.bean.Config;
import com.senao.oop.file.FileFinder;
import com.senao.oop.handler.Handler;
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
	ConfigManager configManager = new ConfigManager();
	ScheduleManager scheduleManager = new ScheduleManager();
	
	/**
	 * 執行備份
	 * @throws IOException
	 */
	public void doBackup() throws Exception {
		
		// 讀取所有 Manager 的 json 檔案
		for(int i=0; i<managers.size(); i++) {
			managers.get(i).processJsonConfig();
			
			// 印出json內容
			//System.out.println(managers.get(i));
		}
		

		List<Config> configs = configManager.getConfigs();
		
		for(Config config : configs) {
			System.out.println(config);
			
			// 當每個檔案要對各 handler 做廣播時，才去產生檔案資訊 的 Candidate 物件
			FileFinder<Candidate> fileFinder =	FileFinderFactory.create("file", config);					
			System.out.println(fileFinder);
			
			for(Candidate candidate : fileFinder) {
				System.out.println(candidate);
				
				this.broadcastToHandlers(candidate);
			}
		}
	}
	
	/**
	 * 在建構式中將要執行的 Manager 加入
	 */
	public void processJSONConfig() {
		managers.add(configManager);
		managers.add(scheduleManager);
		
		// TODO 新的 Manager 加在這
	}
	
	/**
	 * 將每個 candidate 以 廣播 的方式，通知所有 handler 進行處理
	 * @param candidate
	 * @throws Exception
	 */
	private void broadcastToHandlers(Candidate candidate) throws Exception {
		List<Handler> handlers = this.findHandlers(candidate);
		
		byte[] target = null;

		for(Handler handler : handlers)	{
			if(handler==null)
				continue;
			target = handler.perform(candidate, target);
		}
	}
	
	/**
	 * 找出 Candidate 的 Config 中指定的 Handler
	 * file -> Config.Handlers -> Config.Destination
	 * @param candidate
	 * @return
	 * @throws Exception 
	 */
	private List<Handler> findHandlers(Candidate candidate) throws Exception	{
		List<Handler> handlers = new ArrayList<Handler>();
		
		// 從檔案讀取開始
		handlers.add(HandlerFactory.create("file"));
		
		// 接著是設定檔中所設定的 Handlers
		for(String handler : candidate.getConfig().getHandlers()) {
			handlers.add(HandlerFactory.create(handler));
		}
		
		// 最後根據設定檔中的目的地 (Destination) 決定 Handler
		handlers.add(HandlerFactory.create(candidate.getConfig().getDestination()));
		
		return handlers;
	}

}
