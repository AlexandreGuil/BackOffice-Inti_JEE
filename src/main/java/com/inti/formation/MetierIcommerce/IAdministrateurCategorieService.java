package com.inti.formation.MetierIcommerce;

import com.inti.formation.entities.Categorie;
import com.inti.formation.entities.Role;
import com.inti.formation.entities.User;

public interface IAdministrateurCategorieService extends IAdministrateurProdService {
	
	/* ============== Manip Catégorie ============== */
	
	public void saveCategorie(Categorie cat);
	public void deleteCategorie(Categorie cat);
	public void updateCategorie(Categorie cat);
	
	/* ============== Manip User & Role ============== */
	
	public void saveUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public void attribuerRole(Role role, User user);
}
