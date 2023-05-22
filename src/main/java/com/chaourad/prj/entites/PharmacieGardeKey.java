package com.chaourad.prj.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class PharmacieGardeKey implements Serializable{
	private int pharmacie;
	private int garde;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	
	public int getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(int pharmacie) {
		this.pharmacie = pharmacie;
	}
	public int getGarde() {
		return garde;
	}
	public void setGarde(int garde) {
		this.garde = garde;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public PharmacieGardeKey() {
		super();
	}
	
}
