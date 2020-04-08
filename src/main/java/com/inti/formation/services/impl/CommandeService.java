//package com.inti.formation.services.impl;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.inti.formation.entities.Client;
//import com.inti.formation.entities.Commande;
//import com.inti.formation.entities.Panier;
//import com.inti.formation.repositories.ICommandeRepository;
//import com.inti.formation.services.ICommandeService;
//
//@Service("commandeService")
//public class CommandeService implements ICommandeService {
//	
//	@Autowired
//	@Qualifier("commandeRepository")
//	private ICommandeRepository repo;
//
//	@Override
//	public void ajoutOrUpdate(Commande c) {
//		repo.save(c);
//	}
//
//	@Override
//	public void delete(Long id) {
//		repo.deleteById(id);
//	}
//
//	@Override
//	public Commande getById(Long id) {
//		return repo.findById(id).get();
//	}
//
//	@Override
//	public List<Commande> findAll() {
//		return repo.findAll();
//	}
//
//	@Override
//	public Commande getByDate(Date d) {
//		return repo.findByDateCommande(d);
//	}
//
//	@Override
//	public Commande saveCommande(Panier panier, Client client) {
//		Commande cmd = new Commande(new Date(), client, panier.getDictPannierProduit());
//		repo.save(cmd);
//		return cmd;
//	}
//}
