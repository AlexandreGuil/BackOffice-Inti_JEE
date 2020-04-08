package com.inti.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Produit;
import com.inti.formation.repositories.IProduitRepository;
import com.inti.formation.services.IProduitService;

@Service(value = "produitService")
public class ProduitService implements IProduitService{
	
	@Autowired
	@Qualifier(value = "produitRepository")
	private IProduitRepository repo;
	
	@Override
	public List<Produit> findAllProduit() {
		return repo.findAll();
	}

	@Override
	public Produit fingByIdProduit(Long idProguit) {
		return repo.findById(idProguit).get();
	}

	@Override
	public Produit saveOrUpdateProduit(Produit categorie) {
		repo.save(categorie);
		return categorie;
	}

	@Override
	public void deleteProduit(Produit categorie) {
		repo.delete(categorie);
	}

	@Override
	public List<Produit> findProductByKeyWord(String kw) {
		return repo.findProductByKeyWord(kw);
	}

	@Override
	public List<Produit> findProductByCategory(Long idCategorie) {
		return repo.findProductByCategory(idCategorie);
	}

	@Override
	public List<Produit> findSelectedProducts() {
		return repo.findSelectedProducts();
	}

}
