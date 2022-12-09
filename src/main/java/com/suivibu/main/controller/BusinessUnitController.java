package com.suivibu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.service.BusinessUnitService;

@RestController
@RequestMapping(value = "/bu")
public class BusinessUnitController {

	@Autowired
	private BusinessUnitService buService;
	
	

	@GetMapping(value = "/")
	public ResponseEntity<?> getBUs()
	{
		try
		{
			return ResponseEntity.ok(buService.fetchBUs());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
}
