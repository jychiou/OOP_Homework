package com.senao.oop.bean;

/**
 * 設定檔案格式與處理方式
 * @author 014616
 *
 */
public class Config {

	// 檔案格式(副檔名)
	String ext;
	
	// 要備份檔案的目錄
	String location;
	
	// 是否處理子目錄(true:處理子目錄； false:不 處理子目錄)
	boolean subDirectory;
	
	// 備份單位(file:以單一檔案為處理單位； directory:以整個目錄為處理單位)
	String unit;
	
	// 處理完是否刪除檔案(true:刪除； false:不刪除)
	boolean remove;
	
	// (zip:壓縮； encode:加密)
	String handler;
	
	// 處理後要儲存到什麼地方(directory:目錄； db:資料庫)
	String destination;
	
	// 處理後的目錄
	String dir;
	
	// 設定資料庫連接字串
	String connectionString;

	public String getExt() {
		return ext;
	}

	public String getLocation() {
		return location;
	}

	public boolean isSubDirectory() {
		return subDirectory;
	}

	public String getUnit() {
		return unit;
	}

	public boolean isRemove() {
		return remove;
	}

	public String getHandler() {
		return handler;
	}

	public String getDestination() {
		return destination;
	}

	public String getDir() {
		return dir;
	}

	public String getConnectionString() {
		return connectionString;
	}
}
