package com.serge.cv.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serge.cv.Resume;

@Repository("ResumeHibernateDao")
public class ResumeHibernateDao implements ResumeDao {


	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Resume> findbyName(String name) {
		this.entityManager.("from "+Resume.class.getName()+" as resume where resume.name = ?", new Object[]{name});
		List<Resume> result = ( List<Resume>)this.getHibernateTemplate().find();
		return result;
	}

	public Object persist(Resume entity) {
		entityManager.persist(entity);
		return entity;
	}
	
}
