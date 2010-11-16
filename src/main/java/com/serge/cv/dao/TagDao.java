package com.serge.cv.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.serge.cv.Tag;
import com.serge.persistence.model.DaoStandard;


public interface TagDao extends DaoStandard<Tag> {
	
	public List<Tag> findByValue(final String value);

}
