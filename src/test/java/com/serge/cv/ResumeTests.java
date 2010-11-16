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

import java.util.List;
import java.util.Set;

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

import com.serge.cv.Resume.ResumeBuilder;
import com.serge.cv.dao.ResumeDao;
import com.serge.cv.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-context.xml")
@TransactionConfiguration
@Transactional
public class ResumeTests {

	@Autowired
	private ResumeDao resumeDao;

	@Test
	public void testSaveResume() throws Exception {
		Resume.ResumeBuilder resumeBuilder = new ResumeBuilder();  
		resumeBuilder.setProfil(new Profil("name", "surname", "adress", "codePostal", 12, "officenumber","number"));
		Resume resume = this.resumeDao.persist(resumeBuilder.build());
		assertNotNull(resume.getId());
	}
	
	@Test
	public void testFind() throws Exception {
		Resume.ResumeBuilder resumeBuilder = new ResumeBuilder();  
		resumeBuilder.setProfil(new Profil("name", "surname", "adress", "codePostal", 12, "officenumber","number"));
		Resume resumeExpected = this.resumeDao.persist(resumeBuilder.build());
		Set<Resume> resumeFound = this.resumeDao.findbyName("name");
		assertEquals(resumeExpected, resumeFound.iterator().next());
	}


}
