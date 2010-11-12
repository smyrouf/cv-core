package com.serge.cv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Competence  extends AbstractCategorie {
	private Set<ItemCompetence> itemCompetences = new HashSet<ItemCompetence>();
	
	public Set<ItemCompetence> getItemCompetences() {
		return itemCompetences;
	}
	
	public void addItemCompetence(ItemCompetence item) {
		this.itemCompetences.add(item);
		item.setCompetence(this);
	}
	
	public void deleteItemCompetence(ItemCompetence item) {
		if ( !this.equals(item.getCompetence())) {
			throw new IllegalArgumentException("this item doesn't belong to this competence");
		}
		this.itemCompetences.remove(item);		
		item.setCompetence(null);
	}
	
	public void setItemCompetences(Set<ItemCompetence> itemCompetences) {
		this.itemCompetences = itemCompetences;
	}
}
