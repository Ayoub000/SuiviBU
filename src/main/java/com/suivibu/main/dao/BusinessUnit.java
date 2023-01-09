package com.suivibu.main.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "businessunit")
public class BusinessUnit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBU;
	
	private String ville;
	
	
	
	public BusinessUnit() {}
	
	public BusinessUnit(long idBU, String ville) {
		super();
		this.idBU = idBU;
		this.ville = ville;
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
	
}
