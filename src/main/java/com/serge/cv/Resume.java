package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.serge.persistence.model.Identificable;


@Entity
public class Resume implements Identificable<Integer> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Profil 	profil;
	
	@ManyToMany
	private Set<Cursus> cursus;
	
	@ManyToOne
	private Cursus formation;
	
	@ManyToOne
	private Cursus projet;
	
	@ManyToOne
	private SkillReference skillReference;
	
	@ManyToOne
	private User user;
	
	protected Resume() { }

	public Resume(final Profil profil,
				  final SkillReference skillReference) {
		this.setProfil(profil);
		this.setSkillReference(skillReference);
	}

	Resume(ResumeBuilder resumeBuilder) {
		this.setProfil(resumeBuilder.profil);
		this.setCursus(resumeBuilder.cursus);
		this.setSkillReference(resumeBuilder.skillReference);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public Cursus getProjet() {
		return this.projet;
	}

	public void setProjet(Cursus projet) {
		this.projet = projet;
	}

	public SkillReference getSkillReference() {
		return this.skillReference;
	}

	public void setSkillReference(SkillReference skillReference) {
		this.skillReference = skillReference;
	}

	
	

	public Cursus getFormation() {
		return this.formation;
	}

	public void setFormation(Cursus formation) {
		this.formation = formation;
		this.formation.addResume(this);
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

	public static final class ResumeBuilder {
		
		Profil 	profil;
		
		Set<Cursus> cursus = new HashSet<Cursus>();
		
		SkillReference skillReference;
		
		public ResumeBuilder setProfil(Profil profil) {
			this.profil = profil;
			return this;
		}

		public ResumeBuilder addCursus(Cursus cursusSimple) {
			this.cursus.add(cursusSimple);
			return this;
		}

		public ResumeBuilder setSkillReference(SkillReference skillReference) {
			this.skillReference = skillReference;
			return this;
		}

		public Resume build() {
			return new Resume(this);
		}
		
	}
	
	
}
