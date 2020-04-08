package com.inti.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.IdLigneCommande;
import com.inti.formation.entities.LigneCommande;
import com.inti.formation.repositories.ILigneCommandeRepository;
import com.inti.formation.services.ILigneCommandeService;

@Service("ligneDeCommandeService")
public class LigneCommandeService implements ILigneCommandeService {
	
	@Autowired
	@Qualifier(value = "ligneCommandeRepository")
	private ILigneCommandeRepository repo;
	
	@Override
	public List<LigneCommande> findAllLigneDeCommande() {
		return repo.findAll();
	}
	
	/**
	 * 
	 * public LigneCommande findByIdLigneDeCommande(new IdLigneCommande(idCommande, idProduit))
	 * 
	 * idCommande: foreign key of the cammande class
	 * 
	 * idProduit: foreign key of the product class
	 * 
	 * use to resolve the n:n relationship
	 * 
	 */
	
	@Override
	public LigneCommande findByIdLigneDeCommande(IdLigneCommande IdLCmd) {
		return repo.findByIdLigneDeCommande(IdLCmd);
	}

	@Override
	public LigneCommande saveOrUpdateLigneDeCommande(LigneCommande lcmd) {
		return repo.save(lcmd);
	}

	@Override
	public void deleteLignedeCommande(LigneCommande lcmd) {
		repo.delete(lcmd);
	}

}
