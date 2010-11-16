package com.serge.cv.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.serge.cv.Cursus;
import com.serge.persistence.model.DaoStandardHibernate;

@Transactional
@Repository("cursusDao")
public class CursusHibernateDao extends DaoStandardHibernate<Cursus> implements CursusDao {


}
