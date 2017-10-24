package com.senao.oop;

import java.util.List;

import com.senao.oop.bean.Config;
import com.senao.oop.bean.Schedule;
import com.senao.oop.manager.ConfigManager;
import com.senao.oop.manager.ScheduleManager;

/**
 * MyBackup 讀取 config.json 與 schedule.json
 * @author 014616
 *
 */
public class MyBackup {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String configFilePath = "D:/014616/workspace/_Support/OOP_Homework/dist/config.json";
		String scheduleFilePath = "D:/014616/workspace/_Support/OOP_Homework/dist/schedule.json";
		
		
		System.out.println("--------------- Configs -----------------");
		ConfigManager configManager = new ConfigManager();
		configManager.ProcessConfigs(configFilePath);
		
		List<Config> configs = configManager.getConfigs();
		for(int i=0; i<configs.size(); i++) {
			Config config = configs.get(i);
			
			System.out.println("ext:" + config.getExt());					// 檔案格式(副檔名)
			System.out.println("location:" + config.getLocation());			// 要備份檔案的目錄
			System.out.println("subDirectory:" + config.isSubDirectory());	// 是否處理子目錄(true:處理子目錄； false:不 處理子目錄)
			System.out.println("unit:" + config.getUnit());					// 備份單位(file:以單一檔案為處理單位； directory:以整個目錄為處理單位)
			System.out.println("remove:" + config.isRemove());				// 處理完是否刪除檔案(true:刪除； false:不刪除)
			System.out.println("handler:" + config.getHandler());			// (zip:壓縮； encode:加密)
			System.out.println("destination:" + config.getDestination());	// 處理後要儲存到什麼地方(directory:目錄； db:資料庫)
			System.out.println("dir:" + config.getDir());					// 處理後的目錄
			
			System.out.println("-----------------------------------------");
		}
		
		
		System.out.println("--------------- Schedules ---------------");
		ScheduleManager scheduleManager = new ScheduleManager();
		scheduleManager.ProcessSchedules(scheduleFilePath);
		
		List<Schedule> schedules = scheduleManager.getSchedules();
		for(int i=0; i<schedules.size(); i++) {
			Schedule schedule = schedules.get(i);

			System.out.println("ext:" + schedule.getExt());					// 此排程所處理的檔案格式
			System.out.println("time:" + schedule.getTime());				// 此排程所處理的時間
			System.out.println("interval:" + schedule.getInterval());			// 此排程執行的間隔
			
			System.out.println("-----------------------------------------");
		}
	}

}
