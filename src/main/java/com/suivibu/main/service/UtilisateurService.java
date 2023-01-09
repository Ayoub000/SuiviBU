package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.Utilisateur;


public interface UtilisateurService{
	
	@PreAuthorize("hasRole('SUPERADMIN')")
	void deleteUtilisateur(long idUtilisateur);
	
	@PreAuthorize("hasRole('ADMIN')")
	Utilisateur addUtilisateur(Utilisateur utilisateur);
	
	@PreAuthorize("hasRole('ADMIN')")
	List<Utilisateur> fetchUtilisateurs();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	Utilisateur fetchUtilisateur();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	void changePassword(String oldPassword, String newPassword);

}
