package com.senao.oop.db;

import com.senao.oop.candidate.Candidate;

/**
 * 
 * @author 014616
 *
 */
public interface DBHandler {

	/**
	 * 負責建立 database connection
	 */
	public void openConnection();

	/**
	 * 與原本 Handler interface 的 Perform() 完全一樣
	 * @param candidate
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public byte[] perform(Candidate candidate, byte[] target) throws Exception;

	/**
	 * 負責關閉 database connection
	 */
	public void closeConnection();
}
