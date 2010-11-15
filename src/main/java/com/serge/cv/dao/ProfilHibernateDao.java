package com.serge.cv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.serge.cv.Profil;
import com.serge.cv.Resume;
import com.serge.persistence.model.DaoStandardHibernate;

@Transactional
@Repository("profilHibernateDao")
public class ProfilHibernateDao extends DaoStandardHibernate<Profil> implements ProfilDao {

	@Transactional(readOnly=true)
	public List<Profil> findbyResume(final Resume resume) {
		Assert.isNull(resume,"resume cannot be null");
		List<Profil> results = (List<Profil>)this.getHibernateTemplate().find("select profil from "+getEntityClass().getName()+" as profil inner join profil.resume as resume where resume = ?", new Object[]{resume});
		return results;
	}
	
	@Transactional(readOnly=true)
	public List<Profil> findbyName(final String name) {
		Assert.hasLength(name,"name cannot be empty");
		List<Profil> results = (List<Profil>)this.getHibernateTemplate().find("select profil from "+getEntityClass().getName()+" as profil  where profil.name = ?", new Object[]{name});
		return results;
	}
}
