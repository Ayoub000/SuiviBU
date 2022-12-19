package com.suivibu.main.dao;

import org.springframework.security.core.GrantedAuthority;

import com.suivibu.main.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAuthority;

    @Enumerated(EnumType.STRING)
    Role role;
    
    
    public Authority() {}
    


	public Authority(Long idAuthority, Role role) {
		super();
		this.idAuthority = idAuthority;
		this.role = role;
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


	
}
