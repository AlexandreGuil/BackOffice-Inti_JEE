package com.inti.formation.services;

import java.util.List;

import com.inti.formation.entities.Client;

public interface IClientService {

	public void saveOrUpdate(Client c);
	public void delete(Long id);
	public Client getById(Long id);
	public List<Client> findAll();
}
