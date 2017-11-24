package com.senao.oop.handler;

import com.senao.oop.bean.Candidate;

/**
 * 處理方式 - 儲存到資料庫
 * @author 014616
 *
 */
public class DBHandler extends AbstractHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("DBHandler.perform() 處理方式 - 儲存到資料庫");
		
		byte[] result = target;
		
		super.perform(candidate, target);
		
		if (target != null)
			result = this.saveToDatabase(candidate, target);
		
		return result;
	}
	
	/**
	 * 
	 * @param candidate
	 * @param target
	 * @return
	 */
	private byte[] saveToDatabase(Candidate candidate, byte[] target) {

		byte[] result = target;
		
		// TODO ...
		
		return result;
	}
}
