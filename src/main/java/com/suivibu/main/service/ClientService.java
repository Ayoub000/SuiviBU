package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.Client;

public interface ClientService {

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	List<Client> fetchClients();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	Client getClientById(Long id);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	Client addClient(Client client);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	Client updateClient(Long id, Client client);
	
	@PreAuthorize("hasRole('ADMIN')")
	boolean deleteClient(Long id);
}
