package com.inti.formation.MetierIcommerce;
import com.inti.formation.entities.Produit;

public interface IAdministrateurProdService extends IwebShop {
	
	/* ============== Manip Produit ============== */
	
	public void saveProduct(Produit prod);
	public void deleteProduit(Produit prod);
	public void updateProduit(Produit p);
	
}
