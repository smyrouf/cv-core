package com.serge.cv;

import javax.persistence.Basic;
import javax.persistence.Entity;


@Entity
public class Profil extends AbstractCategorie {

	@Basic
	private String nom;
	
	@Basic
	private String prenom;
	
	@Basic
	private String adresse;
	
	@Basic
	private String codePostal;
	
	@Basic
	private int age;
	
	@Basic
	private String telFix;
	
	@Basic
	private String telPortable;


	public Profil(
				final String nom,
				final String prenom,
				final String adresse,
				final String codePostal,
				final int age,
				final String telFix,
				final String telPortable) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.age = age;
		this.telFix = telFix;
		this.telPortable = telPortable;
	}
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the telFix
	 */
	public String getTelFix() {
		return telFix;
	}

	/**
	 * @param telFix the telFix to set
	 */
	public void setTelFix(String telFix) {
		this.telFix = telFix;
	}

	/**
	 * @return the telPortable
	 */
	public String getTelPortable() {
		return telPortable;
	}

	/**
	 * @param telPortable the telPortable to set
	 */
	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}


	
	

}
