package com.serge.cv;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.util.EqualsHelper;
import org.springframework.core.style.ToStringCreator;

import com.serge.persistence.model.Identificable;


@Entity
public class Profil implements Identificable<Integer> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private Resume resume;

	@Basic
	@Column(nullable=false)
	private String name;
	
	@Basic
	@Column(nullable=false)
	private String surname;
	
	@Basic
	private String adress;
	
	@Basic
	private String codePostal;
	
	@Basic
	private int age;
	
	@Basic
	private String officePhoneNumber;
	

	@Basic
	private String mobilePhoneNumber;

	public Profil() { }
	
	public Profil(
				final String name,
				final String surname,
				final String adress,
				final String codePostal,
				final int age,
				final String officePhoneNumber,
				final String mobilePhoneNumber) {
		
		this.codePostal = codePostal;
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.codePostal = codePostal;
		this.officePhoneNumber = officePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return this.surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getAdress() {
		return this.adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCodePostal() {
		return this.codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public int getAge() {
		return this.age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getOfficePhoneNumber() {
		return this.officePhoneNumber;
	}


	public void setOfficePhoneNumber(String officePhoneNumber) {
		this.officePhoneNumber = officePhoneNumber;
	}


	public String getMobilePhoneNumber() {
		return this.mobilePhoneNumber;
	}


	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Resume getResume() {
		return this.resume;
	}

	
	
	@Override
	public String toString() {
		return new ToStringCreator(this)
		.append(this.name)
		.append(this.surname)
		.append(this.codePostal)
		.append(this.officePhoneNumber)
		.append(this.officePhoneNumber)
		.append(this.mobilePhoneNumber).toString();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name)
		.append(this.surname)
		.append(this.age).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		Profil other = (Profil)obj;
		return new EqualsBuilder().append(this.name, other.name)
		.append(this.surname, other.surname)
		.append(this.age, other.age).isEquals();
	}

	
	

	

}
