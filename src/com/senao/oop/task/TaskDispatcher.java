package com.senao.oop.task;

import java.util.List;

import com.senao.oop.bean.Config;
import com.senao.oop.manager.ConfigManager;
import com.senao.oop.manager.JsonManager;

/**
 * 根據需求分配不同的 task
 * @author 014616
 *
 */
public class TaskDispatcher {

	private Task task;

	public void simpleTask(List<JsonManager> managers) throws Exception {

		// 由 TaskFactory 建立 ScheduledTask ，再以 多型 執行 Execute() 
		this.task = TaskFactory.create("simple");

		for(JsonManager jsonManager : managers) {
			if(jsonManager instanceof ConfigManager) {
				List<Config> configs = ((ConfigManager)jsonManager).getConfigs();
				
				for(Config config : configs) {
					System.out.println(config);
					
					task.execute(config, null);
				}
				
			}
		}
	}

	public void scheduledTask(List<JsonManager> managers) throws Exception {
		
		// 由 TaskFactory 建立 ScheduledTask ，再以 多型 執行 Execute() 
		this.task = TaskFactory.create("scheduled");
		// this.task.Execute(configs, schedules);
		// TODO ...
	}

}
