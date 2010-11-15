package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.DiscriminatorType;
import javax.persistence.InheritanceType;

import com.serge.persistence.model.Identificable;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category_type",discriminatorType=DiscriminatorType.STRING)
public class AbstractCategorie implements Identificable<Integer>{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

//	@OneToMany
//	@JoinColumn(name="ID")
//	private Set<Resume> resumes = new HashSet<Resume>();
//	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	
//	public Set<Resume> getResumes() {
//		return resumes;
//	}
//
//	
//	public void addResume(Resume resume) {
//		this.resumes.add(resume);
//	}
//
//	public void setResumes(Set<Resume> resumes) {
//			this.resumes = resumes;
//	}


	
}
