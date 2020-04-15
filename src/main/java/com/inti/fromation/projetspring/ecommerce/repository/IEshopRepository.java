package com.inti.fromation.projetspring.ecommerce.repository;

import com.inti.fromation.projetspring.ecommerce.entities.*;

import java.util.List;

public interface IEshopRepository {

    public void saveCategorie(Categorie categorie);
    public List<Categorie> findAllCategories();
    public Categorie findByIdCategorie(Long idCategorie);
    public void deleteCategrorie(Long idCategorie);
    public void updateCategorie(Categorie categorie);

    public void saveProduit(Produit produit, Long idProduit);
    public List<Produit> findAllproduits();
    public List<Produit> findProduitsParMotCle(String mot);
    public List<Produit> findProduitsParCategorie(Long idCategorie);
    public List<Produit> findProduitsSelectionnes();
    public Produit findByIdProduit(Long idProduit);
    public void deleteProduit(Long idProduit);
    public void updateProduit(Produit produit);

    public void saveUtilisateur(Utilisateur utilisateur);
    public void addUtilisateurRole(Role role, Long idUtilisateur);
    public Commande saveCommande(Panier panier, Client client);

}
