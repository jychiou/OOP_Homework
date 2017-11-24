package com.senao.oop.file;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.senao.oop.bean.Config;

public abstract class AbstractFileFinder<Candidate> implements FileFinder<Candidate> {

	protected Config config;
	protected List<String> files = new ArrayList<String>();
	private int index = -1;

	protected AbstractFileFinder(Config config) {
		if (config != null)
			this.config = config;
	}

	@Override
	public boolean hasNext() {
		if(files.size()>0 && index<files.size()-1)
			return true;
		else
			return false;
	}

	@Override
	public Candidate next() {
		if(++index<files.size())
			return createCandidate(files.get(index));
		else			
			return null;
	}

	@Override
	public void remove() {
		index = -1;
		files.clear();
	}
	
	@Override
	public Iterator<Candidate> iterator() {
		return this;
	}
	
	protected abstract Candidate createCandidate(String	fileName);
}
