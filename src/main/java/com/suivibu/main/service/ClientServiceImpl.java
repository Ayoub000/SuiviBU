package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.Client;
import com.suivibu.main.repo.ClientRepo;


@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepo clientRepo;
	
	
	@Override
	public List<Client> fetchClients() {
		return clientRepo.findAll();
	}

	@Override
	public Client addClient(Client client) {
		return clientRepo.save(client);
	}

}
