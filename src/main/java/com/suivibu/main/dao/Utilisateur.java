package com.suivibu.main.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails{


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUtilisateur;
    
    @Column(unique = true)
    private String username;
    
    private String password;
    private String nom;
    private String prenom;
    private String trigramme;
    private String statut;
    
    
    @OneToMany(mappedBy="utilisateur")
    private Set<Consultant> consultants = new HashSet<>();
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idBU", nullable=false)
    private BusinessUnit bu;
    
    public Utilisateur() {}
    
	public Utilisateur(long idUtilisateur, String username, String password, String nom, String prenom, String trigramme,
			String statut, BusinessUnit bu) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.trigramme = trigramme;
		this.statut = statut;
		this.bu = bu;
	}


	public long getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTrigramme() {
		return trigramme;
	}


	public void setTrigramme(String trigramme) {
		this.trigramme = trigramme;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public BusinessUnit getBu() {
		return bu;
	}


	public void setBu(BusinessUnit bu) {
		this.bu = bu;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}