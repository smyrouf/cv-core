package com.serge.cv;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.Validate;

import com.serge.persistence.model.Identificable;

@Entity
public class Item  implements Identificable<Integer>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Basic
	@Column(nullable=false)
	private Date dateDebut;
	
	@Basic
	@Column(nullable=false)
	private Date dateFin;
	
	@Basic
	private String description;
	
	@ManyToMany
	private Set<Skill> skills = new HashSet<Skill>();
	
	@ManyToOne
	private Cursus cursus;
	
	public Item() { }
	
	
	public Integer getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

	
	public Item(final Date dateDebut,final Date dateFin, final String description) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}
	public Date getDateFin() {
		return this.dateFin;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return this.dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Set<Skill> getSkill() {
		return this.getSkills();
	}


	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}


	

	public Item addSkill(Skill skill) {
		Validate.notNull(skill,"skill cannot be null");
		this.skills.add(skill);
		return this;
	}
	
	public Item delSkill(Skill skill) {
		Validate.notNull(skill,"skill cannot be null");
		this.skills.remove(skill);
		return this;
	}


	public Set<Skill> getSkills() {
		return this.skills;
	}


	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}


	public Cursus getCursus() {
		return cursus;
	}
	
}
