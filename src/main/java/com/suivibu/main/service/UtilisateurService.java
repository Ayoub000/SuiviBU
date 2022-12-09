package com.suivibu.main.service;

import java.util.List;

import com.suivibu.main.dao.Utilisateur;


public interface UtilisateurService{
	
	Utilisateur addUtilisateur(Utilisateur utilisateur);
	List<Utilisateur> fetchUtilisateurs();
	Utilisateur findByUsername(String username);
	void changePassword(String oldPassword, String newPassword);

}
