package com.inti.fromation.projetspring.ecommerce.servicies;

import com.inti.fromation.projetspring.ecommerce.entities.*;

import java.util.List;

public interface IClientServicy {

    public List<Categorie> findAllCategories();
    public Categorie findByIdCategorie(Long idCategorie);

    public List<Produit> findAllproduits();
    public List<Produit> findProduitParMotCle(String mot);
    public List<Produit> findProduitByCategorie(Long idCategorie);
    public List<Produit> findProduitSelectionnes();

    public Produit findByIdProduit(Long idProduit);
    public Commande saveCommande(Panier pannier, Client client);

}
