package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<Long, LigneCommande> dictPannierProduit = new HashMap<Long, LigneCommande>();
	
	/**
	 * 
	 * @param product instance of the Produit class
	 * @param quantite the quantity require by the customer
	 * 
	 * tcheck if the input product and quantity require by the customer 
	 * does not already exist in the pannier
	 * 
	 * if not pushPanierWithLine() push the dictionary with à new item and a new values
	 * else pushPanierWithLine() cumul the quantity existing with the new quantity require
	 * 
	 */
	
	public void pushPanierWithLine(Produit product, Integer quantite) {
		LigneCommande clientQuery = dictPannierProduit.get(product.getIdProduit());
		
		if (clientQuery == null) {
			
			LigneCommande newCommandLine = new LigneCommande();
			newCommandLine.setProduit(product);
			newCommandLine.setQuantiteProdCommande(quantite);
			newCommandLine.setPrix(product.getPrix());
			dictPannierProduit.put(product.getIdProduit(), newCommandLine);
			
		} else {
			clientQuery.setQuantiteProdCommande(clientQuery.getQuantiteProdCommande() + quantite);
		}
	}
	
	public Collection<LigneCommande> getDictPannierProduit() {
		return dictPannierProduit.values();
	}
	
	/**
	 * 
	 * @return the number of objects contains in the panier
	 * 
	 */
	
	public Integer getSize() {
		return dictPannierProduit.size();
	}
	
	
	/**
	 * 
	 * @return the cumulative price of all the product contains in the pannier
	 * 
	 */
	
	public Double getPrixTotal() {
		Double cummul = 0.;
		for(LigneCommande i : dictPannierProduit.values()) {
			cummul += i.getPrix()*i.getQuantiteProdCommande();
		}
		return cummul;
	}
	
	public void deletedictPannierProduitLine(Long idProduit) {
		dictPannierProduit.remove(idProduit);
	}
	
}
