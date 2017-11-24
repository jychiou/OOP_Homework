package com.senao.oop.task;

/**
 * 
 * @author 014616
 *
 */
public class TaskFactory {

	public static Task create(String task) {
		if (task == "simple")
			return new SimpleTask();
		else if (task == "scheduled")
			return new ScheduledTask();
		else
			return null;
	}
}
