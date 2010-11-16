package com.serge.cv.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.serge.cv.Tag;
import com.serge.persistence.model.DaoStandardHibernate;

@Repository("tagDao")
public class TagHibernateDao extends DaoStandardHibernate<Tag> implements TagDao {

	public List<Tag> findByValue(final String value) {
		Assert.hasLength(value,"value cannot be empty"); 
		return (List<Tag>)this.getHibernateTemplate().find("select tag from "+getEntityClass().getName()+" as tag  where tag.value = ?", new Object[]{value});
	}

}
