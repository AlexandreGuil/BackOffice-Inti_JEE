package com.inti.formation.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {
	
	
	private List<Produit> produits;
	private Double prixDuPanier;
	
}
