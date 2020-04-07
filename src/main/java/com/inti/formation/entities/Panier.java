package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<Long, LigneCommande> dictPannierProduit = new HashMap<Long, LigneCommande>();
	
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
	
	public Integer getSize() {
		return dictPannierProduit.size();
	}
	
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
