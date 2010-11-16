package com.serge.cv;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.serge.cv.dao.TagDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-context.xml")
@TransactionConfiguration
@Transactional
public class TagTests {
	
	@Autowired
	private TagDao tagDao;

	@Test
	public void testSaveUser() throws Exception {
		Tag tag = new Tag("tag");
		this.tagDao.persist(tag);
		assertNotNull(tag.getId());
	}
	
	@Test
	public void testFind() throws Exception {
		Tag tagExpected = this.tagDao.persist(new Tag("tag"));
		this.tagDao.persist(new Tag("tag1"));
		this.tagDao.persist(new Tag("tag2"));
		this.tagDao.persist(new Tag("tag3"));
		List<Tag> tags = this.tagDao.findByValue("tag");
		assertEquals(tagExpected, tags.iterator().next());
	}

}
