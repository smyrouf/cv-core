package com.serge.cv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.serge.cv.dao.CursusDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class CursusTests {

	@Autowired
	private CursusDao cursusDao;

	@Test
	public void testSaveCursus() throws Exception {
		Cursus cursus = new Cursus();
		this.cursusDao.persist(cursus);
		assertNotNull(cursus.getId());
	}

}
