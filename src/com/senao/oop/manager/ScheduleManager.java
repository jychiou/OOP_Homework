package com.senao.oop.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senao.oop.bean.Schedule;

public class ScheduleManager extends JsonManager {

	private static String jsonFilePath = "D:/014616/workspace/_Support/OOP_Homework/dist/schedule.json";

	// 提供 List<Schedule> 存放多筆 Schedule 物件
	private List<Schedule> schedules = new ArrayList<Schedule>();

	/**
	 * 取得排程清單
	 * 
	 * @return
	 */
	private List<Schedule> getSchedules() {
		return schedules;
	}

	@Override
	public void processJsonConfig() throws IOException {
		schedules.addAll(((ScheduleManager) getJsonObject(jsonFilePath, ScheduleManager.class)).getSchedules());
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();

		strBuff.append("--------------- Schedules ---------------\n");

		for (int i = 0; i < schedules.size(); i++) {
			strBuff.append(schedules.get(i).toString());
			strBuff.append("-----------------------------------------\n");
		}

		return strBuff.toString();
	}
}
