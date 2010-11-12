package com.serge.cv;

import java.util.HashSet;
import java.util.Set;

public abstract class Cursus extends AbstractCategorie {
	
	private Set<Item> items = new HashSet<Item>();
		

	public Set<Item> getItems() {
		return items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
		item.setCursus(this);
	}
	public void deleteItem(Item item) {
		this.items.remove(item);
		item.setCursus(null);
	}
}
