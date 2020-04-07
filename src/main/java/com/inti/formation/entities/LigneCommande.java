package com.inti.formation.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "lignedecommande")
public class LigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @EmbeddedId instantiate a primary key with a combine foreign key stock in a
	 *             class
	 * 
	 */

	@EmbeddedId // @Embedded inject an object in an antity
	private IdLigneCommande idLigneDeCommande;
	private Integer quantiteProdCommande;
	private Double prix;	
	private Produit produit;
	private Commande commande;
	
	@Basic(optional = false)
	@Column(name = "QUANTITE")
	public Integer getQuantiteProdCommande() {
		return quantiteProdCommande;
	}
	
	public void setQuantiteProdCommande(Integer quantiteProdCommande) {
		this.quantiteProdCommande = quantiteProdCommande;
	}

	@Basic(optional = false)
	@Column(name = "PRIX")
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * 
	 * @ManyToOne
	 * 
	 *            Defines a single valued association to another entity class that
	 *            has many to one multiplicity between the cammand class and the
	 *            produit class
	 * 
	 * @MapsId(value = "idProduit")
	 * 
	 *               Designates a ManyToOne relationship attribute that provides the
	 *               mapping for an EmbeddedId primary key, here "idProduit" is the
	 *               primary key in the produit class
	 * 
	 */
	
	@ManyToOne
	@JoinColumn(name = "PRODUIT_ID")
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	/**
	 * 
	 * @ManyToOne
	 * 
	 *            Defines a single valued association to another entity class that
	 *            has many to one multiplicity between the cammand class and the
	 *            produit class
	 * 
	 * @MapsId(value = "idCommande") Designates a ManyToOne or OneToOne relationship
	 *               attribute that provides the mapping for an EmbeddedId primary
	 *               key, here "idCommande" is the primary key in the command class
	 * 
	 */

	@ManyToOne
	@MapsId(value = "idCommande")
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "LigneCommande [idLigneDeCommande=" + idLigneDeCommande + ", quantiteProdCommande="
				+ quantiteProdCommande + ", prix=" + prix + ", produit=" + produit + ", commande=" + commande + "]";
	}
}
