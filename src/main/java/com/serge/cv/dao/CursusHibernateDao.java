package com.serge.cv.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.serge.cv.Cursus;
import com.serge.cv.Profil;
import com.serge.persistence.model.DaoStandardHibernate;

@Transactional
@Repository("cursusDao")
public class CursusHibernateDao extends DaoStandardHibernate<Cursus> implements CursusDao {


}
