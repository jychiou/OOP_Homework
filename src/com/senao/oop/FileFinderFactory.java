package com.senao.oop;

import com.senao.oop.candidate.Candidate;
import com.senao.oop.bean.Config;
import com.senao.oop.file.FileFinder;
import com.senao.oop.file.LocalFileFinder;

/**
 * 負責建立適合的 FileFinder
 * @author 014616
 *
 */
public class FileFinderFactory {

	public static FileFinder<Candidate> create(String finder, Config config) {
		if (finder == "file")
			return new LocalFileFinder(config);
		else
			return null;
	}
}
