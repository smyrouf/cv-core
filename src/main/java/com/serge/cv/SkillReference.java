package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.commons.lang.Validate;

import com.serge.persistence.model.Identificable;

@Entity
public class SkillReference implements Identificable<Integer> {
	
	@ManyToMany
	private Set<Skill> skills = new HashSet<Skill>();
	
	@OneToMany
	protected Set<Resume> resumes = new HashSet<Resume>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	protected SkillReference() { }
	
	public Set<Skill> getSkill() {
		return this.getSkills();
	}


	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}


	

	public void addSkill(Skill skill) {
		Validate.notNull(skill,"skill cannot be null");
		this.skills.add(skill);
		if ( !skill.getSkillReferences().contains(this)) {
			skill.addSkillReference(this);
		}
	}
	
	public void delSkill(Skill skill) {
		Validate.notNull(skill,"skill cannot be null");
		if ( skill.getSkillReferences().contains(this)) {
			skill.delSkillReference(this);
		}
		this.skills.remove(skill);
	}


	public Set<Skill> getSkills() {
		return this.skills;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	
	public Set<Resume> getResumes() {
		return this.resumes;
	}

	
	public void addResume(Resume resume) {
		this.resumes.add(resume);
	}

	public void setResumes(Set<Resume> resumes) {
			this.resumes = resumes;
	}
	
}
