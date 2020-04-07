package com.inti.formation.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lignedecommande")
public class LigneCommande {
	
	@EmbeddedId // @Embedded
	private IdLigneCommande idLigneDeCommande;
	
	private Integer quantiteProdCommande;
	private Integer prix;
	
	
//	@ManyToOne
//	private Produit produit; // Primary key replace idPorduit
//	
//	@ManyToOne
//	private Commande commande; // Primary key replace idCommande
	
	@ManyToOne
	@MapsId(value = "idProduit")
	private Produit produit;
	

	@ManyToOne
	@MapsId(value = "idCommande")
	private Commande commande;
	
	
	
}
