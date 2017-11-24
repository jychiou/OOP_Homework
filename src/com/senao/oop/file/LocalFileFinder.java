package com.senao.oop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.senao.oop.candidate.Candidate;
import com.senao.oop.candidate.CandidateFactory;
import com.senao.oop.bean.Config;

/**
 * 對本機的搜尋
 * @author 014616
 *
 */
public class LocalFileFinder extends AbstractFileFinder<Candidate> {

	public LocalFileFinder(Config config) {
		super(config);
		
		File folder = new File(config.getLocation());
		files = getFile(folder, config.getExt(), config.isSubDirectory());
	}

	private List<String> getFile(File folder, String ext, boolean subDirectory) {
		List<String> fileList = new ArrayList<String>();
		
		for(File file : folder.listFiles()) {
			if(file.isDirectory()) {
				if(subDirectory)
					fileList.addAll(getFile(file, ext, subDirectory));
			} else if (file.isFile() && file.getName().endsWith("." + ext)) {
				fileList.add(file.getPath());
			}
		}
		
		return fileList;
	}
	
	
	@Override
	protected Candidate createCandidate(String fileName) {

		try {
			File file = new File(fileName);
			
			if(!file.exists())
				return null;
			
			String name = file.getPath();
			
			BasicFileAttributes attributes = Files.readAttributes(Paths.get(name), BasicFileAttributes.class);
			
			FileTime creationTime = attributes.creationTime();
			long size = attributes.size();
			
			// Candidate 只剩下 CandidateFactory 可以 new ，其	他的 class 都不能 new
			return CandidateFactory.create(config, name, new Date(creationTime.toMillis()), "processName", size);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
			
		strBuff.append("-------- LocalFileFinder --------\n");
		
		return strBuff.toString();
	}	
}
