package com.senao.oop.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senao.oop.bean.Schedule;

public class ScheduleManager extends BaseManager {

	// 提供 List<Schedule> 存放多筆 Schedule 物件
	private List<Schedule> schedules = new ArrayList<Schedule>();

	/**
	 * 將 schedule.json 轉成 List<Schedule>
	 * @param scheduleFilePath
	 * @throws IOException 
	 */
	public void ProcessSchedules(String scheduleFilePath) throws IOException {
		Gson gson = new Gson();
		
		String jsonStr = readTxtFile(scheduleFilePath);
		schedules.addAll(((ScheduleManager)gson.fromJson(jsonStr, new TypeToken<ScheduleManager>(){}.getType())).getSchedules());
	}
	
	/**
	 * 取得排程清單
	 * @return
	 */
	public List<Schedule> getSchedules() {
		return schedules;
	}
	
	/**
	 * 提供 List 的 筆數
	 * @return
	 */
	public int Count() {
		return schedules.size();
	}
}
