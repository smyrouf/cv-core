package com.serge.cv.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public List<Resume> findbyName(String login) {
		Assert.isNull(login,"Login cannot be null");
		List<Resume> results = (List<Resume>)this.getHibernateTemplate().find("select resume from "+getEntityClass()+" as resume inner join resume.user as user where user.login = ?", new Object[]{login});
		return results;
	}

	
}
