package com.serge.cv.dao;

import java.util.List;

import com.serge.cv.Profil;
import com.serge.persistence.model.DaoStandard;

public interface ProfilDao  extends  DaoStandard<Profil>{

	public List<Profil> findbyName(final String name);
}
