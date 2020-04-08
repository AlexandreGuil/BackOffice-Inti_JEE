package com.inti.formation.services;

import java.util.List;

import com.inti.formation.entities.Produit;

public interface IProduitService {
	
	/* ===================== CRUD ===================== */
	
	public List<Produit> findAllProduit();
	public Produit fingByIdProduit(Long idProguit);
	
	public Produit saveOrUpdateProduit(Produit categorie);
	public void deleteProduit(Produit categorie);
	
	/* ===================== CRUD ===================== */
	
	public List<Produit> findProductByKeyWord(String kw);
	public List<Produit> findProductByCategory(Long idCategorie);
	public List<Produit> findSelectedProducts();
	
	
}
