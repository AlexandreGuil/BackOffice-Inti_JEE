package com.inti.fromation.projetspring.ecommerce.controlers;

import com.inti.fromation.projetspring.ecommerce.entities.Categorie;
import com.inti.fromation.projetspring.ecommerce.entities.Produit;
import com.inti.fromation.projetspring.ecommerce.servicies.IClientServicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import org.springframework.security.access.method.P;
//import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping(value = "/apiClient")
//@Validated
public class ClientControler {


    @Autowired
    @Qualifier("EshopServicyImpl")
    private IClientServicy service;

    @GetMapping(value = "/findAllCategorie")
    public List<Categorie> findAllCategorie() {
        return service.findAllCategories();
    }

    @GetMapping(value = "/findCategorieById/{id}")
    public Categorie findCategorieById(@PathVariable Long id){
        return service.findByIdCategorie(id);
    }

    @GetMapping(value = "/findAllProduit")
    public List<Produit> findAllProduit() {
        return service.findAllproduits();
    }

    @GetMapping(value = "/findProduitParMotCle/{mot}")
    public List<Produit> findProduitParMotCle(@PathVariable String mot) {
        return service.findProduitParMotCle(mot);
    }

    @GetMapping(value = "/findProduitParCategorie/{id}")
    public List<Produit> findProduitParCategorie(@PathVariable Long id) {
        return service.findProduitByCategorie(id);
    }

    @GetMapping(value = "/findProduitSelectionnes")
    public List<Produit> findProduitSelectionnes() {
        return service.findProduitSelectionnes();
    }

    @GetMapping(value = "/findByIdProduit/{id}")
    public Produit findByIdProduit(@PathVariable Long id){
        return service.findByIdProduit(id);
    }

//    @GetMapping(value = "/enregistrerCommande/{panier}{client}")
//    public Commande enregistrerCommande(@PathVariable Panier panier, Client client){
//        return service.saveCommande(panier, client);
//    }
}
