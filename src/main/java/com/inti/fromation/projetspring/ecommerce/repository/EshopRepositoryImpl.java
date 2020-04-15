package com.inti.fromation.projetspring.ecommerce.repository;

import com.inti.fromation.projetspring.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository(value = "repository")
public class EshopRepositoryImpl implements IEshopRepository {

    @Autowired
    ICategorieRepository categorieRepository;

    @Autowired
    IProduitRepository produitRepository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    ICommandeRepository commandeRepository;

    @Autowired
    ILigneDeCommandeRepository ligneDeCommandeRepository;

    @Autowired
    IUtilisateurRepository utilisateurRepository;

    @Override
    public void saveCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie findByIdCategorie(Long idCategorie) {
        if(categorieRepository.findById(idCategorie).isPresent())
            return categorieRepository.findById(idCategorie).get();
        else
            throw new NullPointerException("The categorie instance was not found in the Categorie table");
    }

    @Override
    public void deleteCategrorie(Long categorie) {
        categorieRepository.deleteById(categorie);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    public void saveProduit(Produit produit, Long idCategorie) {
        Categorie cat;
        if(categorieRepository.findById(idCategorie).isPresent())
            cat = categorieRepository.findById(idCategorie).get();
        else
            throw new NullPointerException("The categorie instance was not found in the Categorie table");
        produit.setCategorie(cat);
        produitRepository.save(produit);
    }

    @Override
    public List<Produit> findAllproduits() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> findProduitsParMotCle(String mot) {
        return produitRepository.findByProduitsParMotCle(mot);
    }

    @Override
    public List<Produit> findProduitsParCategorie(Long idCategorie) {
        return produitRepository.findByProduitsParCategorie(idCategorie);
    }

    @Override
    public List<Produit> findProduitsSelectionnes() {
        return produitRepository.findByProduitsSelectionnes();
    }

    @Override
    public Produit findByIdProduit(Long idProduit) {
        if(produitRepository.findById(idProduit).isPresent())
            return produitRepository.findById(idProduit).get();
        else
            throw new NullPointerException("The produit instance was not found in the Produit table");
    }

    @Override
    public void deleteProduit(Long produit) {
        produitRepository.deleteById(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void addUtilisateurRole(Role role, Long idUtilisateur) {
        if(utilisateurRepository.findById(idUtilisateur).isPresent()) {
            Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).get();
            utilisateur.getRoles().add(role);
        } else
            throw new NullPointerException("The utilisateur instance was not found in the Utilisateur table");
    }

    @Override
    public Commande saveCommande(Panier panier, Client client) {
        Client c = clientRepository.findByNomClientAndAdresseAndTel(client.getNomClient(), client.getAdresse(), client.getTel());
        if(c == null)
            clientRepository.save(client);

        Commande cmd = new Commande();
        cmd.setDateCommande(new Date());
        cmd.setLigneCommandes((List<LigneCommande>) panier.getDictPannier().values());
        for(LigneCommande lc : panier.getDictPannier().values()){
            ligneDeCommandeRepository.save(lc);
        }
        commandeRepository.save(cmd);
        return cmd;
    }
}

