package com.inti.formation.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IdLigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idCommande;
	private Long idProduit;

	public IdLigneCommande() {
	}

	public IdLigneCommande(Long idCommande, Long idProduit) {
		this.idCommande = idCommande;
		this.idProduit = idProduit;
	}

	/**
	 * 
	 * an @Embeddable class require an equals() and an hashCode() methode inherited
	 * of the object class
	 * 
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCommande == null) ? 0 : idCommande.hashCode());
		result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdLigneCommande other = (IdLigneCommande) obj;
		if (idCommande == null) {
			if (other.idCommande != null)
				return false;
		} else if (!idCommande.equals(other.idCommande))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		return true;
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
