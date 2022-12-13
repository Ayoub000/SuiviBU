package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.Consultant;
import com.suivibu.main.repo.ConsultantRepo;


@Service
public class ConsultantServiceImpl implements ConsultantService {
	
	@Autowired
	private ConsultantRepo consultantRepo;

	
	
	@Override
	public List<Consultant> fetchConsultants() {
		return consultantRepo.findAll();
	}
	
	@Override
	public Consultant saveConsultant(Consultant consultant)
	{
		return consultantRepo.save(consultant);
	}

}
