package com.senao.oop.candidate;

import java.util.Date;

import com.senao.oop.bean.Config;

/**
 * Candidate 只剩下 CandidateFactory 可以 new ，其	他的 class 都不能 new
 * 避免用戶端不正當的建立 Candidate 的需求，必須統一用 factory 建立 object，若還是使用 new ，則會編譯錯誤
 * @author 014616
 *
 */
public final class CandidateFactory {

	public static Candidate create(Config config, String name, Date fileDateTime, String processName, long size) {
		return new Candidate(config, name, fileDateTime, processName, size);
	}
	
}
