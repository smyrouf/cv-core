package com.serge.cv.dao;


import serge.core.dao.StandardDao;
import serge.resume.model.User;

public interface UserDao extends StandardDao<User> {
	
	public User findbyLogin(String name);

	public void persist(User entity);
	

}
