package com.serge.cv;


public class ItemCompetence {
	
	private DescriptionType descriptionType;
	
	
	private String description;
	
	private Competence competence;
	
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public ItemCompetence(final DescriptionType desc, final String description) {
		this.descriptionType = desc;
		this.description = description;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	public Competence getCompetence() {
		return competence;
	}
	
	/**
	 * @return the descriptionType
	 */
	public DescriptionType getDescriptionType() {	
		return descriptionType;
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
	
	
}
