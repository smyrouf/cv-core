package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.DiscriminatorType;
import javax.persistence.InheritanceType;

import com.serge.persistence.model.Identity;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category_type",discriminatorType=DiscriminatorType.STRING)
public class AbstractCategorie extends Identity<Integer>{
	
	@OneToMany
	@JoinColumn(name="RESUME_ID")
	private Set<Resume> resumes = new HashSet<Resume>();
	
	
	public Set<Resume> getResumes() {
		return resumes;
	}

	
	public void addResume(Resume resume) {
		this.resumes.add(resume);
	}

	public void setResumes(Set<Resume> resumes) {
			this.resumes = resumes;
	}

}
