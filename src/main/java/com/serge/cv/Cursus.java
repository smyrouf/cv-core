package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.serge.persistence.model.Identificable;

@Entity
public class Cursus  implements Identificable<Integer> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@ManyToMany
	private Set<Resume> resumes = new HashSet<Resume>();
	
	@OneToMany
	private Set<Tag> tags = new HashSet<Tag>();
	
	@Basic
	private String title;
	
	public Cursus() { }
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany
	private Set<Item> items = new HashSet<Item>();

	public Set<Item> getItems() {
		return this.items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public Cursus addItem(Item item) {
		this.items.add(item);
		item.setCursus(this);
		return this;
	}
	public Cursus deleteItem(Item item) {
		this.items.remove(item);
		item.setCursus(null);
		return this;
	}
	
	public Set<Resume> getResumes() {
		return this.resumes;
	}

	
	public void addResume(Resume resume) {
		this.resumes.add(resume);
	}


	public void delResume(Resume resume) {
		this.resumes.remove(resume);
	}

	
	public void setResumes(Set<Resume> resumes) {
			this.resumes = resumes;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Tag> getTags() {
		return this.tags;
	}


	public void addTag(Tag tag) {
		this.tags.add(tag);
		if (!tag.getEntity().equals(this) ) {
			tag.setEntity(this);
		}
	}


	public void delTag(Tag tag) {
		if (tag.getEntity() != null ) {
			tag.setEntity(null);
		}
		this.tags.remove(tag);
	}

	
}
