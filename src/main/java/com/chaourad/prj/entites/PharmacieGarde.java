package com.chaourad.prj.entites;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class PharmacieGarde {
	@EmbeddedId
    private PharmacieGardeKey id;
   
	@ManyToOne
	@JoinColumn(name = "pharmacie", insertable = false, updatable = false)
	private Pharmacie pharmacie;

	@ManyToOne
	@JoinColumn(name = "garde", insertable = false, updatable = false)
	private Garde garde;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
	public PharmacieGardeKey getId() {
		return id;
	}
	public void setId(PharmacieGardeKey id) {
		this.id = id;
	}
	public Pharmacie getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}
	public Garde getGarde() {
		return garde;
	}
	public void setGarde(Garde garde) {
		this.garde = garde;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public PharmacieGarde() {
		super();
	}
    
    
}
