package com.suivibu.main.dao;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "businessunit")
public class BusinessUnit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBU;
	
	private String ville;
	
	@JsonManagedReference
	@OneToMany(mappedBy="bu")
    private Set<Utilisateur> utilisateurs = new HashSet<>();
	
	
	
	public BusinessUnit() {}
	
	public BusinessUnit(long idBU, String ville, Set<Utilisateur> utilisateurs) {
		super();
		this.idBU = idBU;
		this.ville = ville;
		this.utilisateurs = utilisateurs;
	}
	

	public long getIdBU() {
		return idBU;
	}
	public void setIdBU(long idBU) {
		this.idBU = idBU;
	}
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	

}
