package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

import com.serge.persistence.model.Identificable;

@Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@Entity
public class TaggedEntity  implements Identificable<Integer>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToMany
	private Set<Tag> tags = new HashSet<Tag>();
	
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Tag> getTags() {
		return this.tags;
	}


	public void addTag(Tag tag) {
		this.tags.add(tag);
		if (!tag.getTaggedEntities().contains(this) ) {
			tag.addTaggedEntities(this);
		}
	}

	
	

	public void delTag(Tag tag) {
		if (!tag.getTaggedEntities().contains(this) ) {
			tag.delTaggedEntities(null);
		}
		this.tags.remove(tag);
	}

}
