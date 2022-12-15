package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.Utilisateur;
import com.suivibu.main.repo.UtilisateurRepo;



@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepo utilisateurRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateur)
	{
		return utilisateurRepo.save(utilisateur);
	}
	
	@Override
	public Utilisateur findByUsername(String username) {
		return utilisateurRepo.findByUsername(username);
	}
	
	@Override
	public List<Utilisateur> fetchUtilisateurs() throws AccessDeniedException {
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		for(Utilisateur utilisateur : utilisateurs)
		{
			utilisateur.setPassword("******");
		}
		return utilisateurs;
	}
	
	@Override
	public void changePassword(String oldPassword, String newPassword) {

		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		String username = currentUser.getName();

		if (authenticationManager != null) {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
		} else {
			return;
		}
		
		Utilisateur utilisateur = (Utilisateur)userDetailsService.loadUserByUsername(username);

		utilisateur.setPassword(passwordEncoder.encode(newPassword));
		utilisateurRepo.save(utilisateur);

	}


}
