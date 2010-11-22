package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;


@Entity
public class User extends TaggedEntity {
	
	@Basic
	@Column(unique = true, nullable = false, length=50)
	private String login;
	
	@Basic
	@Column(unique = false, nullable = false, length=50)
	private String password;
	
	
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
	
	
	public String toString() {
		return new ToStringCreator(this).append(this.login).append(this.password).toString();
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.login)
		.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		User other = (User)obj;
		return new EqualsBuilder().append(this.login, other.login).isEquals();
	}

	
}
