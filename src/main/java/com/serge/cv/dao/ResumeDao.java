package com.serge.cv.dao;

import java.util.List;

import com.serge.cv.Resume;

public interface ResumeDao  {

	public List<Resume> findbyName(final String Name);
	
}
