package com.inti.formation.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Client;
import com.inti.formation.entities.Commande;
import com.inti.formation.repositories.IClientRepository;
import com.inti.formation.repositories.ICommandeRepository;
import com.inti.formation.services.IClientService;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	IClientRepository repo;
	
	@Autowired
	ICommandeRepository commandeRepo;

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

	@Override
	public Commande findLastCommande(Client c) {
		Date d = null;
		for (Commande commande : c.getCommandes())
		{
			if (commande.getDateCommande().compareTo(d)>0)
			{
				d = commande.getDateCommande();
			}
		}
		return commandeRepo.findByDateCommande(d);
	}

}
