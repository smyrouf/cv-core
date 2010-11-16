package com.serge.cv;

import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

import com.serge.persistence.model.Identificable;

@Entity
public class Item  extends TaggedEntity {
	

	@Basic
	@Column(nullable=false)
	@Access(AccessType.PROPERTY)
	private Date dateDebut;
	
	@Basic
	@Column(nullable=false)
	@Access(AccessType.PROPERTY)
	private Date dateFin;
	
	@Basic
	@Access(AccessType.PROPERTY)
	private String description;
	
	@Basic
	@Column(nullable=false)
	@Access(AccessType.PROPERTY)
	private String title;
	
	
	@ManyToMany
	private Set<Skill> skills = new HashSet<Skill>();
	
	@ManyToOne
	private Cursus cursus;
	
	public Item() { }
	

	
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
	

	public void setTitle(String title) {
		this.title = title;
	}


	public String getTitle() {
		return title;
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
		return this.cursus;
	}
	
	
	@Override
	public String toString() {
		return new ToStringCreator(this).append(this.dateDebut).append(this.dateFin).append(this.title).append(this.description).toString();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.dateDebut).append(this.dateFin).append(this.title).append(this.description)
		.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		Item other = (Item)obj;
		return new EqualsBuilder().append(this.dateDebut, other.dateDebut)
			.append(this.dateFin, other.dateFin)
			.append(this.title, other.title).append(this.description, other.description).isEquals();
	}


	
}
