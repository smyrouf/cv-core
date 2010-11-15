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

import com.serge.cv.dao.ProfilDao;
import com.serge.cv.dao.ResumeDao;
import com.serge.cv.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-context.xml")
@TransactionConfiguration
@Transactional
public class ProfilTests {

	@Autowired
	private ProfilDao profilDao;

	@Test
	public void testSaveProfil() throws Exception {
		Profil profil = new Profil("name","surname","adress","codePostal",10,"514-582-1234","514-234-1983");
		this.profilDao.persist(profil);
		assertNotNull(profil.getId());
	}
	
	@Test
	public void testFind() throws Exception {
		Profil profilExpected = this.profilDao.persist(new Profil("name","surname","adress","codePostal",10,"514-582-1234","514-234-1983"));
		this.profilDao.persist(new Profil("name2","surname","adress","codePostal",10,"514-582-1234","514-234-1983"));
		this.profilDao.persist(new Profil("name3","surname","adress","codePostal",10,"514-582-1234","514-234-1983"));
		this.profilDao.persist(new Profil("name4","surname","adress","codePostal",10,"514-582-1234","514-234-1983"));
		List<Profil> profils = this.profilDao.findbyName("name");
		assertEquals(profils.get(0), profilExpected);
	}

//	@Test
//	@Transactional
//	public void testSaveAndGet() throws Exception {
//		Session session = sessionFactory.getCurrentSession();
//		Order order = new Order();
//		order.getItems().add(new Item());
//		session.save(order);
//		session.flush();
//		// Otherwise the query returns the existing order (and we didn't set the
//		// parent in the item)...
//		session.clear();
//		Order other = (Order) session.get(Order.class, order.getId());
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getOrder());
//	}
//
//	@Test
//	@Transactional
//	public void testSaveAndFind() throws Exception {
//		Session session = sessionFactory.getCurrentSession();
//		Order order = new Order();
//		Item item = new Item();
//		item.setProduct("foo");
//		order.getItems().add(item);
//		session.save(order);
//		session.flush();
//		// Otherwise the query returns the existing order (and we didn't set the
//		// parent in the item)...
//		session.clear();
//		Order other = (Order) session.createQuery("select o from Order o join o.items i where i.product=:product")
//				.setString("product", "foo").uniqueResult();
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getOrder());
//	}

}
