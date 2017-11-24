package com.senao.oop.handler;

import com.senao.oop.candidate.Candidate;
import com.senao.oop.db.DBBackupHandler;
import com.senao.oop.db.DBHandler;
import com.senao.oop.db.DBLogHandler;

/**
 * 
 * @author 014616
 *
 */
public class DBAdapter extends AbstractHandler {

	DBHandler backupHandler = new DBBackupHandler();
	DBHandler logHandler = new DBLogHandler();

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		super.perform(candidate, target);
		
		saveBackupToDB(candidate, target);
		saveLogToDB(candidate, target);
		
		return target;
	}

	/**
	 * 將資料寫入DB
	 * @param candidate
	 * @param target
	 * @throws Exception
	 */
	private void saveBackupToDB(Candidate candidate, byte[] target) throws Exception {
		backupHandler.openConnection();
		backupHandler.perform(candidate, target);
		backupHandler.closeConnection();
	}

	/**
	 * 將 log 寫進資料庫
	 * @param candidate
	 * @param target
	 * @throws Exception
	 */
	private void saveLogToDB(Candidate candidate, byte[] target) throws Exception {
		logHandler.openConnection();
		logHandler.perform(candidate, target);
		logHandler.closeConnection();
	}

}
