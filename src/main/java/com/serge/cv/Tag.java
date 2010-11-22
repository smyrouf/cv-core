package com.serge.cv;

import java.util.Set;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

import com.serge.persistence.model.Identificable;

@Entity
public class Tag implements Identificable<Integer>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Basic
	private String value;
	
	@Basic
	private Double score;

	@ManyToMany
	private Set<TaggedEntity> taggedEntities;

	protected Tag() { }
	
	public Tag(final String value) {
		this.setValue(value);
	}
	
	
	public Tag(final String value, final Double score) {
		this.setValue(value);
		this.setScore(score);
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public void setTaggedEntities(Set<TaggedEntity> taggedEntities) {
		this.taggedEntities = taggedEntities;
	}

	public Set<TaggedEntity> getTaggedEntities() {
		return taggedEntities;
	}

	
	public String toString() {
		return new ToStringCreator(this).append(this.value).append(this.score).toString();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.value).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		Tag other = (Tag)obj;
		return new EqualsBuilder().append(this.value, other.value).isEquals();
	}

	public void addTaggedEntities(TaggedEntity taggedEntity) {
		this.taggedEntities.add(taggedEntity);
		
	}

	public void delTaggedEntities(TaggedEntity taggedEntity) {
		this.taggedEntities.remove(taggedEntity);
	}

	
}
