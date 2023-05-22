package com.chaourad.prj.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(
	name = "pharmacie_favorite" ,
	joinColumns = @JoinColumn(referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
	)
	private List<Pharmacie> pharmacies;
	

	@OneToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pharmacie> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public Favorite() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
