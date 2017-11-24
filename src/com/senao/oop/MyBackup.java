package com.senao.oop;


/**
 * MyBackup 讀取 config.json 與 schedule.json
 * @author 014616
 *
 */
public class MyBackup {

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
