package com.serge.cv.dao;


import com.serge.cv.User;
import com.serge.persistence.model.DaoStandard;


public interface UserDao extends  DaoStandard<User> {
	
	public User findbyLogin(String name);

}
