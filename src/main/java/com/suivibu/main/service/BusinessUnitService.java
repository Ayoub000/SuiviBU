package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.BusinessUnit;

public interface BusinessUnitService {
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	List<BusinessUnit> fetchBUs();
}
