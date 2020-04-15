package com.inti.fromation.projetspring.ecommerce.servicies;


import com.inti.fromation.projetspring.ecommerce.entities.Produit;

public interface IAdminProduitServicy extends IClientServicy {

    public void saveProduit(Produit produit, Long idCategorie);
    public void deleteProduit(Long idProduit);
    public void updateProduit(Produit produit);

}
