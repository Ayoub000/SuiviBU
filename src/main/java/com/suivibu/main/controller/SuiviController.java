package com.suivibu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.service.ConsultantService;

@RestController
@RequestMapping(value = "/suivi")
public class SuiviController {
	
	@Autowired
	private SuiviService suiviService;

	
}
