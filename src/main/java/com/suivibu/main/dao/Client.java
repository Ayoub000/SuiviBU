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
@Table(name = "client")
public class Client {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClient;
	
	private String nom;
	private String interlocuteur;
	private String mail;
	private String tel;
	private String adresse;
	
	@JsonManagedReference(value="consultantclient")
	@OneToMany(mappedBy="client", cascade = CascadeType.PERSIST)
    private Set<Consultant> consultants = new HashSet<>();
	
	
	public Client() {}

	public Client(long idClient, String nom, String interlocuteur, String mail, String tel, String adresse,
			Set<Consultant> consultants) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.interlocuteur = interlocuteur;
		this.mail = mail;
		this.tel = tel;
		this.adresse = adresse;
		this.consultants = consultants;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getInterlocuteur() {
		return interlocuteur;
	}

	public void setInterlocuteur(String interlocuteur) {
		this.interlocuteur = interlocuteur;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Consultant> getConsultants() {
		return consultants;
	}

	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}
	
	

}
