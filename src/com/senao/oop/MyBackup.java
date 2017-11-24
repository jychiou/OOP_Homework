package com.senao.oop;

/**
 * 主要是在 加密、壓縮、備份 ... 等功能
 * 
 * @author 014616
 * 
 */
public class MyBackup {

	/*
	 * 目前 user 處理方式有 壓縮、加密、儲存到其他目錄， 儲存到資料庫 4 種方式，未來不排除有新的方式會加入。
	 */

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		MyBackupService myBackupService = new MyBackupService();
		myBackupService.processJSONConfig();
		myBackupService.doBackup();
	}
}
