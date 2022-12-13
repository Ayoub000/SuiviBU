package com.suivibu.main.service;

import java.util.List;

import com.suivibu.main.dao.Consultant;


public interface ConsultantService {
	
	List<Consultant> fetchConsultants();
	Consultant saveConsultant(Consultant consultant);

}
