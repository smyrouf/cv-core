/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.serge.cv;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.serge.cv.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-context.xml")
@TransactionConfiguration
@Transactional
public class UserTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSaveUser() throws Exception {
		User user = new User("login","passoword");
		this.userDao.persist(user);
		assertNotNull(user.getId());
	}
	
	@Test
	public void testFind() throws Exception {
		User userExpected = this.userDao.persist(new User("login","password"));
		this.userDao.persist(new User("login2","password"));
		this.userDao.persist(new User("login3","password"));
		this.userDao.persist(new User("login4","password"));
		User user = this.userDao.findbyLogin("login");
		assertEquals(userExpected.getLogin(), user.getLogin());
	}

}
