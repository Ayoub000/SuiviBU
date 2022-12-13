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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    
    
    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "utilisateurAuthority", 
    		   joinColumns = @JoinColumn(name = "idUtilisateur"), 
    		   inverseJoinColumns = @JoinColumn(name = "idAuthority"))
    private Set<Authority> authorities;
    
    
    
    public Utilisateur() {}



	public Utilisateur(long idUtilisateur, String username, String password, String nom, String prenom,
			String trigramme, String statut, Set<Consultant> consultants, BusinessUnit bu, Set<Authority> authorities) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.trigramme = trigramme;
		this.statut = statut;
		this.consultants = consultants;
		this.bu = bu;
		this.authorities = authorities;
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
		return authorities;
	}

	
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	

	public Set<Consultant> getConsultants() {
		return consultants;
	}



	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}

}