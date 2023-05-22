package com.chaourad.prj.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Garde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;

	@JsonIgnore
	@OneToMany(mappedBy = "garde" , fetch = FetchType.EAGER)
	private List<PharmacieGarde> pharmacieGarde;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PharmacieGarde> getPharmacieGarde() {
		return pharmacieGarde;
	}

	public void setPharmacieGarde(List<PharmacieGarde> pharmacieGarde) {
		this.pharmacieGarde = pharmacieGarde;
	}

	
	
	
}
