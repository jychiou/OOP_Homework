package com.senao.oop.handler;

import com.senao.oop.candidate.Candidate;

/**
 * 所有 handler 共用程式碼處
 * @author 014616
 *
 */
public abstract class AbstractHandler implements Handler {
	
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		
		//System.out.println("AbstractHandler.perform()");
		
		byte[] result = target;
		
		return result;
	}
}
