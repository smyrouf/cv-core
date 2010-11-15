package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.core.style.ToStringCreator;

import com.serge.persistence.model.Identificable;

@Entity
public class User implements Identificable<Integer> {
	
	@Basic
	@Access(AccessType.PROPERTY)
	@Column(unique = true, nullable = false, length=50)
	private String login;
	
	@Basic
	@Access(AccessType.PROPERTY)
	@Column(unique = false, nullable = false, length=50)
	private String password;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	@OneToMany
	private Set<Resume> resumes = new HashSet<Resume>();
	
	protected User () { }
	

	public User(final String login, final String password) {
		this.login = login;
		this.password = password;
	}
	
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Resume> getResumes() {
		return this.resumes;
	}
	
	public void setResumes(Set<Resume> resumes) {
		this.resumes = resumes;
	}
	
	public void addResume(Resume resume) {
		this.resumes.add(resume);
		if (resume.getUser() != this ) {
			resume.setUser(this);
		}
	}
	
	public void removeResume(Resume resume) {
		this.resumes.remove(resume);
		resume.setUser(null);
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		return new ToStringCreator(this).append(this.login).append(this.password).toString();
	}

}
