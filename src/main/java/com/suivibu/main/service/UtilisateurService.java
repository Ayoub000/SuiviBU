package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.Utilisateur;


public interface UtilisateurService{
	
	@PreAuthorize("hasRole('SUPERADMIN')")
	Utilisateur addUtilisateur(Utilisateur utilisateur);
	
	@PreAuthorize("hasRole('SUPERADMIN')")
	List<Utilisateur> fetchUtilisateurs();
	
	Utilisateur findByUsername(String username);
	void changePassword(String oldPassword, String newPassword);

}
