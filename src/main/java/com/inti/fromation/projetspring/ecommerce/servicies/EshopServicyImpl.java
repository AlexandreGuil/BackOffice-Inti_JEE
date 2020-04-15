package com.inti.fromation.projetspring.ecommerce.servicies;

import com.inti.fromation.projetspring.ecommerce.entities.*;
import com.inti.fromation.projetspring.ecommerce.repository.IEshopRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Data
@Service(value = "EshopServicyImpl")
@Transactional
public class EshopServicyImpl implements IAdminCategorieServicy {

    @Autowired
    @Qualifier(value = "repository")
    IEshopRepository eshopRepository;

    @Override
    public void saveCategorie (Categorie categorie) {
        eshopRepository.saveCategorie(categorie);
    }

    @Override
    public void deleteCategrorie(Long idCategorie) {
        eshopRepository.deleteCategrorie(idCategorie);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        eshopRepository.updateCategorie(categorie);
    }

    @Override
    public void saveUser(Utilisateur utilisateur) {
        eshopRepository.saveUtilisateur(utilisateur);
    }

    @Override
    public void addUtilisateurRole(Role role, Long idUtilisateur) {
        eshopRepository.addUtilisateurRole(role, idUtilisateur);
    }

    @Override
    public void saveProduit(Produit produit, Long idCategorie) {
        eshopRepository.saveProduit(produit, idCategorie);
    }

    @Override
    public void deleteProduit(Long idProduit) {
        eshopRepository.deleteProduit(idProduit);
    }

    @Override
    public void updateProduit(Produit produit) {
        eshopRepository.updateProduit(produit);
    }

    @Override
    public List<Categorie> findAllCategories() {
        return eshopRepository.findAllCategories();
    }

    @Override
    public Categorie findByIdCategorie(Long idCategorie) {
        return eshopRepository.findByIdCategorie(idCategorie);
    }

    @Override
    public List<Produit> findAllproduits() {
        return eshopRepository.findAllproduits();
    }

    @Override
    public List<Produit> findProduitParMotCle(String mot) {
        return eshopRepository.findProduitsParMotCle(mot);
    }

    @Override
    public List<Produit> findProduitByCategorie(Long idCategorie) {
        return eshopRepository.findProduitsParCategorie(idCategorie);
    }

    @Override
    public List<Produit> findProduitSelectionnes() {
        return eshopRepository.findProduitsSelectionnes();
    }

    @Override
    public Produit findByIdProduit(Long idProduit) {
        return eshopRepository.findByIdProduit(idProduit);
    }

    @Override
    public Commande saveCommande(Panier pannier, Client client) {
        return eshopRepository.saveCommande(pannier, client);
    }
}
