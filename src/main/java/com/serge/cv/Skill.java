package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

import com.serge.persistence.model.Identificable;

@Entity
public class Skill extends TaggedEntity {
	
	
	@Enumerated(EnumType.STRING)
	private DescriptionType descriptionType;
	
	@Basic
	@Column(nullable=false)
	private String description;
	
	@Basic
	@Column(nullable=false)
	private String title;
	
	@Basic
	@Column(nullable=false)
	private String level;
	
	@ManyToMany
	private Set<Item> items = new HashSet<Item>();
	
	@ManyToMany
	private Set<Resume> resumes = new HashSet<Resume>();
	
	protected Skill() { }

	public Set<Resume> getResumes() {
		return this.resumes;
	}

	public void setResumes(Set<Resume> resumes) {
		this.resumes = resumes;
	}

	
	
	public Skill(final DescriptionType desc, final String description) {
		this.descriptionType = desc;
		this.description = description;
	}
		
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	
	/**
	 * @return the descriptionType
	 */
	public DescriptionType getDescriptionType() {	
		return this.descriptionType;
	}
	/**
	 * @param descriptionType the descriptionType to set
	 */
	public void setDescriptionType(DescriptionType descriptionType) {
		this.descriptionType = descriptionType;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Item> getItems() {
		return items;
	}
	
	public void addItems(Item item) {
		Validate.notNull(item, "item cannot be null !!");
		this.items.add(item);
		if (! item.getSkills().contains(item) ) {
			item.addSkill(this);
		}
	}

	public void delItem(Item item) {
		Validate.notNull(item, "item cannot be null !!");
		this.items.remove(item);
		if ( item.getSkills().contains(item) ) {
			item.delSkill(this);
		}
	}

	
	
	public void addResume(Resume resume) {
		Validate.notNull(resume, "resume cannot be null !!");
		this.resumes.add(resume);
		if (! resume.getSkills().contains(this) ) {
			resume.addSkill(this);
		}
	}

	public void delResume(Resume resume) {
		Validate.notNull(resume, "resume cannot be null !!");
		this.resumes.remove(resume);
		if ( resume.getSkills().contains(this) ) {
			resume.delSkill(this);
		}
	}

	public String toString() {
		return new ToStringCreator(this)
			.append(this.descriptionType)
			.append(this.title)
			.append(this.level).toString();
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.descriptionType)
		.append(this.title)
		.append(this.level).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		Skill other = (Skill)obj;
		return new EqualsBuilder().append(this.descriptionType, other.descriptionType)
		.append(this.title, other.title).isEquals();
	}

	
}
