package com.senao.oop.handler;

import com.senao.oop.candidate.Candidate;

/**
 * 所有 handler 的抽象化 interface，使用端只依賴此 interface，
 * 而不會依賴實際 handler
 * @author 014616
 *
 */
public interface Handler {
	
	/**
	 * 
	 * @param cadidate
	 * @param target 前一個 handler 的 Perform() 回傳值
	 * @return 亦為 byte[] ，將傳入下一個 handler 的 Perform()
	 * @throws Exception 
	 */
	public byte[] perform(Candidate cadidate, byte[] target) throws Exception;
}
