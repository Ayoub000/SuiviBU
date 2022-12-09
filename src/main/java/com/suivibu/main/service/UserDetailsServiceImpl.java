package com.suivibu.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.Utilisateur;
import com.suivibu.main.repo.UtilisateurRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UtilisateurRepo utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurRepo.findByUsername(username);
		if (utilisateur == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			return utilisateur;
		}
	}

}
