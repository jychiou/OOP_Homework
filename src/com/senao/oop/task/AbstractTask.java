package com.senao.oop.task;

import java.util.ArrayList;
import java.util.List;

import com.senao.oop.FileFinderFactory;
import com.senao.oop.HandlerFactory;
import com.senao.oop.candidate.Candidate;
import com.senao.oop.bean.Config;
import com.senao.oop.bean.Schedule;
import com.senao.oop.file.FileFinder;
import com.senao.oop.handler.Handler;

public abstract class AbstractTask implements Task {

	protected FileFinder<Candidate> fileFinder;
	
	@Override
	public void execute(Config config, Schedule shedule) throws Exception {
		// 一開始一定要將要備份的檔案全部找出來，首先必須由 FileFinderFactory 建立正確的	FileFinder
		this.fileFinder = FileFinderFactory.create("file", config);
	}
	
	/**
	 * 將每個 candidate 以 廣播 的方式，通知所有 handler 進行處理
	 * @param candidate
	 * @throws Exception
	 */
	protected void broadcastToHandlers(Candidate candidate) throws Exception {
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
	protected List<Handler> findHandlers(Candidate candidate) throws Exception	{
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
