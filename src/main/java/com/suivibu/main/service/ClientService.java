package com.suivibu.main.service;

import java.util.List;

import com.suivibu.main.dao.Client;

public interface ClientService {

	List<Client> fetchClients();
	Client saveClient(Client client);
}
