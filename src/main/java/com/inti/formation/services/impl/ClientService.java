package com.inti.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Client;
import com.inti.formation.repositories.IClientRepository;
import com.inti.formation.services.IClientService;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	IClientRepository repo;

	@Override
	public Client getById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Client> findAll() {
		return repo.findAll();
	}

	@Override
	public void saveOrUpdate(Client c) {
		repo.save(c);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

}
