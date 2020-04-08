package com.inti.formation.services;

import java.util.Date;
import java.util.List;

import com.inti.formation.entities.Commande;

public interface ICommandeService {
	
	public void ajoutOrUpdate(Commande c);
	public void delete(Long id);
	public Commande getById(Long id);
	public List<Commande> findAll();
	public Commande getByDate(Date d);

}
