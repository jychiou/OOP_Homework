package com.senao.oop.db;

import com.senao.oop.candidate.Candidate;

/**
 * 將備份資料存進資料庫 (MyBackup table)
 * 
 * @author 014616
 *
 */
public class DBBackupHandler extends AbstractDBHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {

		System.out.println("DBBackupHandler.perform() 處理方式 - 將備份資料存進資料庫 (MyBackup table)");
		
		super.perform(candidate, target);
		
		// TODO ...
		
		return target;
	}

}
