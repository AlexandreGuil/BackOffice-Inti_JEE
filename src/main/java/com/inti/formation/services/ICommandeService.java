package com.inti.formation.services;

import java.util.Date;
import java.util.List;

import com.inti.formation.entities.Client;
import com.inti.formation.entities.Commande;
import com.inti.formation.entities.Panier;

public interface ICommandeService {
	
	public void ajoutOrUpdate(Commande c);
	public void delete(Long id);
	public Commande getById(Long id);
	public List<Commande> findAll();
	public Commande getByDate(Date d);
	
	/* =================== begin Alex =================== */
	
	public Commande saveCommande(Panier panier, Client client);
	
	/* =================== begin Alex =================== */
}
