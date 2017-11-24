package com.senao.oop.handler;

import com.senao.oop.bean.Candidate;
import com.senao.oop.util.AESencrp;

/**
 * 處理方式 - 加密
 * @author 014616
 *
 */
public class EncodeHandler extends AbstractHandler {

	@Override
	public byte[] perform(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("EncodeHandler.perform() 處理方式 - 加密");
		
		byte[] result = target;
		
		super.perform(candidate, target);
		
		if (target != null)
			result = this.encodeData(candidate, target);
		
		return result;
	}
	
	/**
	 * 將 byte[] 編碼後回傳 byte[]
	 * @param candidate
	 * @param target
	 * @return
	 * @throws Exception
	 */
	private byte[] encodeData(Candidate candidate, byte[] target) throws Exception {
		
		System.out.println("EncodeHandler.encodeData()\r\t=> 將 byte[] 編碼後回傳 byte[]\t(AESencrp.encrypt)");
		
		byte[] result = AESencrp.encrypt(target);
		
		return result;
	}
	
}
