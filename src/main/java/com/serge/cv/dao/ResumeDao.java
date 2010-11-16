package com.serge.cv.dao;

import java.util.List;
import java.util.Set;

import com.serge.cv.Resume;
import com.serge.cv.User;
import com.serge.persistence.model.DaoStandard;

public interface ResumeDao  extends  DaoStandard<Resume>{

	public Set<Resume> findbyName(final String Name);
	
}
