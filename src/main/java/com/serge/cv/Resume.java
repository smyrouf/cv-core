package com.serge.cv;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.serge.persistence.model.Identity;

@Entity
public class Resume extends Identity<Long> {
	
	@ManyToOne
	@JoinColumn(name="profil_fk")
	private Profil 	profil;
	
	@ManyToOne
	@JoinColumn(name="experience_professionelle_fk")
	private Experience experienceProfessionnelle;
	
	@ManyToOne
	@JoinColumn(name="formation_fk")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="projet_fk")
	private Projet projet;
	
	@ManyToOne
	@JoinColumn(name="competence_fk")
	private Competence competence;
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
	public Resume() {
		super();
	}

	public Resume(final Profil profil, 
				  final Formation formation, 
				  final Experience experienceProfessionnelle,  
				  final Projet projet,
				  final Competence competence) {
		this.profil = profil;
		this.profil.addResume(this);
		this.formation = formation;
		this.formation.addResume(this);
		this.competence = competence;
		this.competence.addResume(this);
		this.experienceProfessionnelle = experienceProfessionnelle;
		this.experienceProfessionnelle.addResume(this);
		this.projet = projet;
		this.projet.addResume(this);
		
	}
	

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	

	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		profil.addResume(this);
		this.profil = profil;
	}
	/**
	 * @return the experienceProfessionnelle
	 */
	public Experience getExperienceProfessionnelle() {
		return experienceProfessionnelle;
	}
	/**
	 * @param experienceProfessionnelle the experienceProfessionnelle to set
	 */
	public void setExperienceProfessionnelle(Experience experienceProfessionnelle) {
		this.experienceProfessionnelle = experienceProfessionnelle;
	}
	/**
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}
	/**
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	/**
	 * @return the projet
	 */
	public Projet getProjet() {
		return projet;
	}
	/**
	 * @param projet the projet to set
	 */
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	/**
	 * @return the competence
	 */
	public Competence getCompetence() {
		return competence;
	}
	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	
}
