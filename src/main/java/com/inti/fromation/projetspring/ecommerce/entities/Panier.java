package com.inti.fromation.projetspring.ecommerce.entities;

import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
public class Panier {

    private Map<Long, LigneCommande> dictPannier = new HashMap<>();

    public void addProduct(Produit p, int quantite) {
        if(dictPannier.get(p.getIdProduit()) != null)
            dictPannier.get(p.getIdProduit()).setQuantite(quantite + dictPannier.get(p.getIdProduit()).getQuantite());
        else {
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setProduit(p);
            ligneCommande.setQuantite(quantite);
            ligneCommande.setPrix(p.getPrix());
        }
    }

    public Collection<LigneCommande> getCommandes() {
        return dictPannier.values();
    }

    public double getPrixTotalPannier() {
        double res = 0;
        for(LigneCommande i : dictPannier.values())
            res += i.getPrix() * i.getQuantite();
        return res;
    }
}
