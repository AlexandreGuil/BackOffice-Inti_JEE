package com.inti.formation.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Client;
import com.inti.formation.repositories.IClientRepository;
import com.inti.formation.services.IClientService;

@Service(value = "clientService")
public class ClientService implements IClientService {
	
	@Autowired
	@Qualifier("clientRepository")
	private IClientRepository repo;
	
	@Override
	public Client getById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Client> findAll() {
		return repo.findAll();
	}

	@Override
	public Client saveOrUpdate(Client c) {
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

}
