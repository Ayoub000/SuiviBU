package com.suivibu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.dao.Consultant;
import com.suivibu.main.service.ConsultantService;



@RestController
@RequestMapping(value = "/consultant")
public class ConsultantController {

	@Autowired
	private ConsultantService consultantService;
	
	
	@GetMapping(value = "/")
	public ResponseEntity<?> getConsultants()
	{
		try
		{
			return ResponseEntity.ok(consultantService.fetchConsultants());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<?> addConsultant(@RequestBody Consultant consultant)
	{
		Consultant newConsultant = null;
		HttpStatus status = null;
		try
		{
			newConsultant = consultantService.addConsultant(consultant);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return newConsultant != null ? ResponseEntity.status(status).body(newConsultant) : ResponseEntity.status(status).build();
	}
	
}
