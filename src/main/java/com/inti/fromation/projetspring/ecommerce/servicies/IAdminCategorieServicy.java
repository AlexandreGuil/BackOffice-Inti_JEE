package com.inti.fromation.projetspring.ecommerce.servicies;

import com.inti.fromation.projetspring.ecommerce.entities.Categorie;
import com.inti.fromation.projetspring.ecommerce.entities.Role;
import com.inti.fromation.projetspring.ecommerce.entities.Utilisateur;

public interface IAdminCategorieServicy extends IAdminProduitServicy {

    public void saveCategorie(Categorie categorie);
    public void deleteCategrorie(Long idCategorie);
    public void updateCategorie(Categorie categorie);

    public void saveUser(Utilisateur utilisateur);
    public void addUtilisateurRole(Role role, Long idUtilisateur);

}
