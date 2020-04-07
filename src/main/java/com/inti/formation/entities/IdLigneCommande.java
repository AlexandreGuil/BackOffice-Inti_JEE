package com.inti.formation.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IdLigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCommande;
	private Long idProduit;
	
	public IdLigneCommande() {}

	public IdLigneCommande(Long idCommande, Long idProduit) {
		this.idCommande = idCommande;
		this.idProduit = idProduit;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
}
