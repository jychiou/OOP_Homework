package com.senao.oop.db;

import com.senao.oop.candidate.Candidate;

/**
 * 
 * @author 014616
 *
 */
public abstract class AbstractDBHandler implements DBHandler {

	@Override
	public void openConnection() {
		System.out.println("AbstractDBHandler.openConnection() 負責建立 database connection");
		
		// TODO ...
		
	}

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		System.out.println("AbstractDBHandler.perform() 將資料寫入DB");
		
		// TODO ...
		
		return null;
	}

	@Override
	public void closeConnection() {
		System.out.println("AbstractDBHandler.closeConnection() 負責關閉 database connection");
		
		// TODO ...
	}
}
