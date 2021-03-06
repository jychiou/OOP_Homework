package com.senao.oop.bean;

/**
 * 設定自動排程時間
 * @author 014616
 *
 */
public class Schedule {

	// 此排程所處理的檔案格式
	private String ext;
	
	// 此排程所處理的時間
	private String time;
	
	// 此排程執行的間隔
	private String interval;

	public String getExt() {
		return ext;
	}

	public String getTime() {
		return time;
	}

	public String getInterval() {
		return interval;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		
		strBuff.append("ext:" + getExt() + "\n");					// 此排程所處理的檔案格式
		strBuff.append("time:" + getTime() + "\n");					// 此排程所處理的時間
		strBuff.append("interval:" + getInterval() + "\n");			// 此排程執行的間隔
		
		return strBuff.toString();
	}
}
