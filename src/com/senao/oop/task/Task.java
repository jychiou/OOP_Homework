package com.senao.oop.task;

import com.senao.oop.bean.Config;
import com.senao.oop.bean.Schedule;

/**
 * 將所有 task 抽象化成 Task interface，使用端只依賴 (認識、耦合) 此interface，而不會依賴實際 task
 * 只定義一個 Execute() ，傳入 Config 與 Schedule 兩個物
 * @author 014616
 *
 */
public interface Task {

	public void execute(Config config, Schedule shedule) throws Exception;
}
