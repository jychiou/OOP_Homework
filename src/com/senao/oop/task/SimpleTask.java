package com.senao.oop.task;

import com.senao.oop.candidate.Candidate;
import com.senao.oop.bean.Config;
import com.senao.oop.bean.Schedule;

public class SimpleTask extends AbstractTask {

	@Override
	public void execute(Config config, Schedule shedule) throws Exception {
		
		// 找到全部要備份的檔案
		super.execute(config, shedule);
		
		// 最後再對所有的檔案以 broadcast 方式執行所有 handler
		// 當每個檔案要對各 handler 做廣播時，才去產生檔案資訊 的 Candidate 物件
		for(Candidate candidate : fileFinder) {
			this.broadcastToHandlers(candidate);
		}
	}
}
