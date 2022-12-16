package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.Client;

public interface ClientService {

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	List<Client> fetchClients();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	Client addClient(Client client);
}
