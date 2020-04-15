package com.inti.fromation.projetspring.ecommerce.controlers;

import com.inti.fromation.projetspring.ecommerce.entities.Categorie;
import com.inti.fromation.projetspring.ecommerce.entities.Role;
import com.inti.fromation.projetspring.ecommerce.entities.Utilisateur;
import com.inti.fromation.projetspring.ecommerce.servicies.IAdminCategorieServicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/apiAdminCategorie")
//@Validated
public class AdminCategorieController {

    @Autowired
    @Qualifier("EshopServicyImpl")
    private IAdminCategorieServicy serv;

    @PostMapping(value = "/saveCategorie")
    public void saveCategorie(@RequestBody Categorie cat) {
        serv.saveCategorie(cat);
    }

    @DeleteMapping(value = "/deleteCategorie/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        serv.deleteCategrorie(id);
    }

    @PutMapping(value = "/updateCategorie")
    public void updateCategorie(@RequestBody Categorie cat) {
        serv.updateCategorie(cat);
    }

    @PostMapping(value = "/saveUtilisateur")
    public void saveUtilisateur(@RequestBody Utilisateur user) {
        serv.saveUser(user);
    }

    @PostMapping(value = "/attribuerRole/{role}/{idUtilisateur}")
    public void attribuerRole(@PathVariable Role role, @PathVariable Long idUtilisateur) {
        serv.addUtilisateurRole(role, idUtilisateur);
    }
}
