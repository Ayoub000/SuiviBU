package com.suivibu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.dao.Client;
import com.suivibu.main.service.ClientService;



@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	
	
	@Autowired
	private ClientService clientService;
	
	
	
	
	@GetMapping(value = "/")
	public ResponseEntity<?> getClients()
	{
		try
		{
			return ResponseEntity.ok(clientService.fetchClients());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addClient(@RequestBody Client client)
	{
		Client newClient = null;
		HttpStatus status = null;
		try
		{
			newClient = clientService.saveClient(client);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return newClient != null 
				? ResponseEntity.status(status).body(newClient) 
						: ResponseEntity.status(status).build();
	}

}
