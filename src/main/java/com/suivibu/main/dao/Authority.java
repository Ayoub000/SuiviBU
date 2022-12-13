package com.suivibu.main.dao;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.suivibu.main.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority{

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAuthority;

    @Enumerated(EnumType.STRING)
    Role role;
    
    
    @JsonBackReference
    @ManyToMany(mappedBy = "authorities")
    private Set<Utilisateur> utilisateurs;
    
    
    public Authority() {}
    


	public Authority(Long idAuthority, Role role, Set<Utilisateur> utilisateurs) {
		super();
		this.idAuthority = idAuthority;
		this.role = role;
		this.utilisateurs = utilisateurs;
	}



	public Long getIdAuthority() {
		return idAuthority;
	}


	public void setIdAuthority(Long idAuthority) {
		this.idAuthority = idAuthority;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String getAuthority() {
		return role.name();
	}



	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}



	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
	
}
