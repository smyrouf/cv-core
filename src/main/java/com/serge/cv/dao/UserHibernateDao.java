package com.serge.cv.dao;


import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import serge.core.dao.StandardHibernateDao;
import serge.resume.model.User;

public class UserHibernateDao  extends StandardHibernateDao<User> implements UserDao {

	public User findbyLogin(String login) {
		List<?> results = this.getHibernateTemplate().find("select user from "+User.class.getName()+" as user where user.login = ?", new Object[]{login});
		return (User) DataAccessUtils.uniqueResult(results);
	}

	
}
