package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.BusinessUnit;
import com.suivibu.main.repo.BusinessUnitRepo;

@Service
public class BusinessUnitServiceImpl implements BusinessUnitService {
	
	@Autowired
	private BusinessUnitRepo buRepo;
	
	
	@Override
	public List<BusinessUnit> fetchBUs() {
		return buRepo.findAll();
	}

}
