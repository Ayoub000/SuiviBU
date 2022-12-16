package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.Consultant;
import com.suivibu.main.dao.Utilisateur;
import com.suivibu.main.repo.ConsultantRepo;


@Service
public class ConsultantServiceImpl implements ConsultantService {
	
	@Autowired
	private ConsultantRepo consultantRepo;

	
	
	@Override
	public List<Consultant> fetchConsultants() {
		
		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return consultantRepo.findByUtilisateur(utilisateur);
	}
	
	
	@Override
	public Consultant addConsultant(Consultant consultant)
	{
		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		consultant.setUtilisateur(utilisateur);
		return consultantRepo.save(consultant);
	}

}
