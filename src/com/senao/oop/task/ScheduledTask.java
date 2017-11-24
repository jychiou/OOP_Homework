package com.senao.oop.task;

import com.senao.oop.candidate.Candidate;
import com.senao.oop.bean.Config;
import com.senao.oop.bean.Schedule;

public class ScheduledTask extends AbstractTask {
	
	@Override
	public void execute(Config config, Schedule shedule) throws Exception {
		
		// 找到全部要備份的檔案
		super.execute(config, shedule);
		
		// TODO ... 自行加以實做
		
		// 最後再對所有的檔案以 broadcast 方式執行所有 handler
		for(Candidate candidate : fileFinder) {
			this.broadcastToHandlers(candidate);
		}
	}
}
