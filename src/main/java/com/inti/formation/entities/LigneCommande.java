package com.inti.formation.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lignedecommande")
public class LigneCommande {
	
	/* ==================== begin test =========================== */
	
	/**
	 * @EmbeddedId instantiate a primary key with a combine foreign key stock in a
	 *             class
	 * 
	 */

//	@EmbeddedId // @Embedded inject an object in an antity
//	private IdLigneCommande idLigneDeCommande;
	
	/* ==================== end test =========================== */
	
	private Long idLigneDeCommande;
	private Produit produit;
	
	/* ==================== begin test =========================== */
	
	private Integer quantiteProdCommande;
	private Double prix;
	
	/* ==================== end test =========================== */
	
//	private Produit produit;
//	private Commande commande;
	
	/* ==================== begin test =========================== */
	
	@Id
	@Column(name = "LIGNE_DE_COMMANDE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdLigneDeCommande() {
		return idLigneDeCommande;
	}
	
	public void setIdLigneDeCommande(Long idLigneDeCommande) {
		this.idLigneDeCommande = idLigneDeCommande;
	}
	
	/* ==================== end test =========================== */
	
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
	
	/* ==================== begin test =========================== */
	
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

//	@ManyToOne
//	@MapsId(value = "idCommande")
//	public Commande getCommande() {
//		return commande;
//	}
//
//	public void setCommande(Commande commande) {
//		this.commande = commande;
//	}

	/* ==================== end test =========================== */
	
	@Override
	public String toString() {
		return "LigneCommande [idLigneDeCommande=" + idLigneDeCommande + ", quantiteProdCommande="
				+ quantiteProdCommande + ", prix=" + prix + ", produit=" + produit + /* ", commande=" + commande + */ "]";
	}
}
