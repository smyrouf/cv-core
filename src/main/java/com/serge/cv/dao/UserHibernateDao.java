package com.serge.cv.dao;


import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.serge.cv.User;
import com.serge.persistence.model.DaoStandardHibernate;

@Repository("UserDao")
@Transactional
public class UserHibernateDao  extends DaoStandardHibernate<User> implements UserDao {

	@Transactional(readOnly = true)
	public User findbyLogin(String login) {
		List<?> results = this.getHibernateTemplate().find("select user from "+User.class.getName()+" as user where user.login = ?", new Object[]{login});
		return (User) DataAccessUtils.uniqueResult(results);
	}

	
}
