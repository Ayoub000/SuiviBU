package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.BusinessUnit;
import com.suivibu.main.dao.Utilisateur;
import com.suivibu.main.repo.BusinessUnitRepo;

@Service
public class BusinessUnitServiceImpl implements BusinessUnitService {
	
	@Autowired
	private BusinessUnitRepo buRepo;
	
	
	@Override
	public List<BusinessUnit> fetchBUs() {
		List<BusinessUnit> bus = buRepo.findAll();
		for(BusinessUnit bu : bus)
		{
			for(Utilisateur utilisateur : bu.getUtilisateurs())
			{
				utilisateur.setPassword("******");
			}
		}
		return bus;
	}

}
