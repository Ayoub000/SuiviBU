package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.BusinessUnit;

public interface BusinessUnitService {
	
	@PreAuthorize("hasRole('SUPERADMIN')")
	List<BusinessUnit> fetchBUs();
}
