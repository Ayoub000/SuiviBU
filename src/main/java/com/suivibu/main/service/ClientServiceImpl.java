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
	
	@Override
	public Client getClientById(Long id) {
		return clientRepo.findById(id).orElse(null);
	}
	

	@Override
	public Client updateClient(Long id, Client client) {
		Client existingClient = clientRepo.findById(id).orElse(null);
		if (existingClient == null) {
		  return null;
	    }
	    
	    existingClient.setNom(client.getNom());
	    existingClient.setAdresse(client.getAdresse());
	    existingClient.setInterlocuteur(client.getInterlocuteur());
	    existingClient.setMail(client.getMail());
	    existingClient.setTel(client.getTel());
	    
	    return clientRepo.save(existingClient);
	}
	
	@Override
	public boolean deleteClient(Long id) {
	    Client existingClient = clientRepo.findById(id).orElse(null);
	    if (existingClient == null) {
	      return false;
	    }
	    clientRepo.delete(existingClient);
	    return true;
    }


}
