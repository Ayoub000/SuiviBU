package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.Consultant;


public interface ConsultantService {
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	List<Consultant> fetchConsultants();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	Consultant addConsultant(Consultant consultant);

}
