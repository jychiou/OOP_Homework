package com.senao.oop.bean;

/**
 * 描述待處理檔案的資訊
 * @author 014616
 *
 */
public class Candidate {

	// 所根據的 Config 物件，由 constructor 傳入
	private Config config;
	
	// 檔案的日期與時間
	private String fileDateTime;
	
	// 檔案名稱
	private String name;
	
	// 處理檔案的 process(以後會用到)
	private String processName;
	
	// 檔案 size
	private long size;
	
	public Candidate() {
		
	}

	public Candidate(Config config, String fileDateTime, String name, String processName, long size) {
		this.config = config;
		this.fileDateTime = fileDateTime;
		this.name = name;
		this.processName = processName;
		this.size = size;
	}
	
	public Config getConfig() {
		return config;
	}

	public String getFileDateTime() {
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
			
		strBuff.append("= config:" + getConfig() + "\n");				// 所根據的 Config 物件，由 constructor 傳入
		strBuff.append("= fileDateTime:" + getFileDateTime() + "\n");	// 檔案的日期與時間
		strBuff.append("= name:" + getName() + "\n");					// 檔案名稱
		strBuff.append("= processName:" + getProcessName() + "\n");	// 處理檔案的 process(以後會用到)
		strBuff.append("= size:" + getSize() + "\n");					// 檔案 size
		
		return strBuff.toString();
	}
	
}
