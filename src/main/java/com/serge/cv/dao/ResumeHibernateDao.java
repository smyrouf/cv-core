package com.serge.cv.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.serge.cv.Resume;
import com.serge.cv.User;
import com.serge.persistence.model.DaoStandardHibernate;

@Repository("resumeHibernateDao")
@Transactional
public class ResumeHibernateDao extends DaoStandardHibernate<Resume> implements ResumeDao  {


	@Transactional(readOnly=true)
	public Set<Resume> findbyName(String login) {
		Assert.hasLength(login,"name cannot be empty");
		Set<Resume> result = new HashSet<Resume>();
		//result.addAll(this.getHibernateTemplate().find("select user.resume from "+User.class.getClass()+" as user where user.login = ? ", new Object[]{login}));
		List<?> results = this.getHibernateTemplate().find("select user from "+User.class.getName()+" as user where user.login = ?", new Object[]{login});
		return result;
	}

	
}
