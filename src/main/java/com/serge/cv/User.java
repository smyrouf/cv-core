package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import com.serge.persistence.model.Identity;

public class User extends Identity<Long> {
	
	private String login;
	private String password;
	
	@OneToMany(mappedBy="user")
	private Set<Resume> resumes = new HashSet<Resume>();
	
	public User () { }
	
	
	public User(final String login, final String password) {
		this.login = login;
		this.password = password;
	}
	
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Resume> getResumes() {
		return resumes;
	}
	
	public void setResumes(Set<Resume> resumes) {
		this.resumes = resumes;
	}
	
	public void addResume(Resume resume) {
		this.resumes.add(resume);
		resume.setUser(this);
	}
	
	public void removeResume(Resume resume) {
		this.resumes.remove(resume);
		resume.setUser(null);
	}
	
	
}
