package com.senao.oop.db;

import com.senao.oop.candidate.Candidate;

/**
 * 將 log 寫進資料庫 (MyLog table)
 * 
 * @author 014616
 *
 */
public class DBLogHandler extends AbstractDBHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {

		System.out.println("DBLogHandler.perform() 將 log 寫進資料庫 (MyLog table)");
		
		super.perform(candidate, target);
		
		// TODO ...
		
		return target;
	}
	
}
