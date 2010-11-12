package com.serge.cv;

import java.util.Date;

public class Item {
	private Date dateDebut;
	private Date dateFin;
	private String description;
	private Long id;
	private Cursus cursus;
	
	/**
	 * @return the cursus
	 */
	public Cursus getCursus() {
		return cursus;
	}

	/**
	 * @param cursus the cursus to set
	 */
	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	public Item(final Date dateDebut,final Date dateFin, final String description) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}
	public Date getDateFin() {
		return dateFin;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
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
		description = description;
	}
}
