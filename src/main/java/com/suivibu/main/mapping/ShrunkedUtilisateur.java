package com.suivibu.main.mapping;

import java.util.Set;

import com.suivibu.main.dao.Authority;
import com.suivibu.main.dao.BusinessUnit;
import com.suivibu.main.dao.Consultant;
import com.suivibu.main.dao.Utilisateur;

public class ShrunkedUtilisateur {

	private long idUtilisateur;
    private String nom;
    private String prenom;
    private String trigramme;
    private String statut;
    private Set<Consultant> consultants;
    private BusinessUnit bu;
    private Set<Authority> authorities;
	
	
	@SuppressWarnings("unchecked")
	public ShrunkedUtilisateur(Utilisateur utilisateur)
	{
		idUtilisateur = utilisateur.getIdUtilisateur();
		nom = utilisateur.getNom();
		prenom = utilisateur.getPrenom();
		trigramme = utilisateur.getTrigramme();
		statut = utilisateur.getStatut();
		consultants = utilisateur.getConsultants();
		bu = utilisateur.getBu();
		authorities = (Set<Authority>) utilisateur.getAuthorities();
	}


	public long getIdUtilisateur() {
		return idUtilisateur;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getTrigramme() {
		return trigramme;
	}


	public String getStatut() {
		return statut;
	}


	public Set<Consultant> getConsultants() {
		return consultants;
	}


	public BusinessUnit getBu() {
		return bu;
	}


	public Set<Authority> getAuthorities() {
		return authorities;
	}
	
	
	
	
}
