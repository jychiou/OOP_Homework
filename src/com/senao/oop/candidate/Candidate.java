package com.senao.oop.candidate;

import java.util.Date;

import com.senao.oop.bean.Config;

/**
 * 描述待處理檔案的資訊
 * @author 014616
 *
 */
public final class Candidate {

	// 所根據的 Config 物件，由 constructor 傳入
	private final Config config;
	
	// 檔案的日期與時間
	private final Date fileDateTime;
	
	// 檔案名稱
	private final String name;
	
	// 處理檔案的 process(以後會用到)
	private final String processName;
	
	// 檔案 size
	private final long size;
	
	protected Candidate(Config config, String name, Date fileDateTime, String processName, long size) {
		this.config = config;
		this.name = name;
		this.fileDateTime = fileDateTime;
		this.processName = processName;
		this.size = size;
	}
	
	public Config getConfig() {
		return config;
	}

	public Date getFileDateTime() {
		return fileDateTime;
	}

	public String getName() {
		return name;
	}

	public String getProcessName() {
		return processName;
	}

	public long getSize() {
		return size;
	} 
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();

		strBuff.append("===========Candidate===========\n");
		strBuff.append("= config:" + getConfig() + "\n");				// 所根據的 Config 物件，由 constructor 傳入
		strBuff.append("= fileDateTime:" + getFileDateTime() + "\n");	// 檔案的日期與時間
		strBuff.append("= name:" + getName() + "\n");					// 檔案名稱
		strBuff.append("= processName:" + getProcessName() + "\n");	// 處理檔案的 process(以後會用到)
		strBuff.append("= size:" + getSize() + "\n");					// 檔案 size
		strBuff.append("===============================\n");
		
		return strBuff.toString();
	}
	
}
