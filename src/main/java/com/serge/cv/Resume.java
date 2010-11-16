package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cascade;
import org.springframework.core.style.ToStringCreator;


import com.serge.persistence.model.Identificable;


@Entity
public class Resume extends TaggedEntity  {
	
	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Profil 	profil;
	
	@ManyToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Cursus> cursus;
	
	
	@ManyToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Skill> skills = new HashSet<Skill>();
	
	@ManyToOne
	private User user;
	
	protected Resume() { }

	public Resume(final Profil profil,
				  final Set<Skill> skills ) {
		this.setProfil(profil);
		this.setSkills(skills);
	}

	Resume(ResumeBuilder resumeBuilder) {
		this.setProfil(resumeBuilder.profil);
		this.setCursus(resumeBuilder.cursus);
		this.setSkills(skills);
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
		user.addResume(this);
	}

	

	public Profil getProfil() {
		return this.profil;
	}
	
	public void setProfil(Profil profil) {
		this.profil = profil;
		profil.setResume(this);
	}
	
	

	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
	public Resume addSkill(Skill skill) {
		this.skills.add(skill);
		if (!skill.getResumes().contains(this) ) {
			skill.addResume(this);
		}
		return this;
	}
	

	public Resume delSkill(Skill skill) {
		this.skills.remove(skill);
		if (skill.getResumes().contains(this) ) {
			skill.delResume(this);
		}
		return this;
	}


	
	
	public void setCursus(Set<Cursus> cursus) {
		this.cursus = cursus;
	}

	public Set<Cursus> getCursus() {
		return this.cursus;
	}
	
	public Resume addCursus(Cursus cursusSimple) {
		this.cursus.add(cursusSimple);
		if (!cursusSimple.getResumes().contains(this) ) {
			cursusSimple.addResume(this);
		}
		return this;
	}

	public Resume delCursus(Cursus cursusSimple) {
		this.cursus.remove(cursusSimple);
		if (cursusSimple.getResumes().contains(this) ) {
			cursusSimple.delResume(this);
		}
		return this;
	}

	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		Resume other = (Resume)obj;
		return new EqualsBuilder().append(this.getId(),other.getId()).isEquals();
	}
	
	public static final class ResumeBuilder {
		
		Profil 	profil;
		
		Set<Cursus> cursus = new HashSet<Cursus>();
		
		Set<Skill> skills = new HashSet<Skill>();
		
		public ResumeBuilder setProfil(Profil profil) {
			this.profil = profil;
			return this;
		}

		public ResumeBuilder addCursus(Cursus cursusSimple) {
			this.cursus.add(cursusSimple);
			return this;
		}

		public ResumeBuilder addSkill(Skill skill) {
			this.skills.add(skill);
			return this;
		}

		public Resume build() {
			return new Resume(this);
		}
		
	}
	
	
}
