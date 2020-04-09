package com.inti.formation.MetierIcommerce;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.inti.formation.entities.Categorie;
import com.inti.formation.entities.Client;
import com.inti.formation.entities.Commande;
import com.inti.formation.entities.Panier;
import com.inti.formation.entities.Produit;

public interface IwebShop {

	/* ============== consulter les coatégorie ============== */
	
	public List<Categorie> findAllCategories();
	public Categorie findCategorieById(Long idCategorie);
	
	/* ============== consulter les produit ============== */
	
	public List<Produit> findAllProduct();
	public Produit findProduitById(Long idProduct);
	public List<Produit> findProductByKeyWord(String kw);
	public List<Produit> findProductByCategory(Long idCategorie);
	public List<Produit> findSelectedProducts();

	/* ============== Save commande ============== */
	
	public Commande enregistrerCommande(Panier panier, Client client);
	
}
