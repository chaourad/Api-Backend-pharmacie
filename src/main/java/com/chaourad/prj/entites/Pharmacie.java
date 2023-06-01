package com.chaourad.prj.entites;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;
    private double laltitude;
    private double longitude;
    private String image;
    @JsonIgnore
    @OneToOne(mappedBy = "pharmacy")
    private User user;
    @JsonIgnore
	@OneToMany(mappedBy = "pharmacie", fetch = FetchType.LAZY)
	private List<PharmacieGarde > pharmacieGarde;


    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne
    private Zone zone;

    // Constructeurs, getters, setters, etc.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLaltitude() {
        return laltitude;
    }

    public void setLaltitude(double laltitude) {
        this.laltitude = laltitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Pharmacie() {
        super();
    }

	public List<PharmacieGarde> getPharmacieGarde() {
		return pharmacieGarde;
	}

	public void setPharmacieGarde(List<PharmacieGarde> pharmacieGarde) {
		this.pharmacieGarde = pharmacieGarde;
	}
    
    
}
