package com.inti.formation.MetierIcommerce;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.formation.entities.Categorie;
import com.inti.formation.entities.Client;
import com.inti.formation.entities.Commande;
import com.inti.formation.entities.Panier;
import com.inti.formation.entities.Produit;
import com.inti.formation.entities.Role;
import com.inti.formation.entities.User;
import com.inti.formation.repositories.ICategorieRepository;
import com.inti.formation.repositories.ICommandeRepository;
import com.inti.formation.repositories.IProduitRepository;
import com.inti.formation.repositories.IRoleRepository;
import com.inti.formation.repositories.IUserRepository;

@Service("webShop")
@Transactional
public class ImplWebShop implements IAdministrateurCategorieService{
	
	@Autowired
	@Qualifier("produitRepository")
	private IProduitRepository prodRepo;
	
	@Autowired
	@Qualifier("categorieRepository")
	private ICategorieRepository catRepo;
	
	@Autowired
	@Qualifier("commandeRepository")
	private ICommandeRepository comRepo;
	
	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepo;
	
	@Autowired
	@Qualifier("roleRepository")
	private IRoleRepository roleRepo;
	
	
	@Override
	public void saveProduct(Produit prod) {
		prodRepo.save(prod);
	}

	@Override
	public void deleteProduit(Produit prod) {
		prodRepo.delete(prod);
	}

	@Override
	public void updateProduit(Produit p) {
		prodRepo.save(p);
	}

	@Override
	public List<Categorie> findAllCategories() {
		return catRepo.findAll();
	}

	@Override
	public Categorie findCategorieById(Long idCategorie) {
		return catRepo.findById(idCategorie).get();
	}

	@Override
	public List<Produit> findAllProduct() {
		return prodRepo.findAll();
	}

	@Override
	public Produit findProduitById(Long idProduct) {
		return prodRepo.findById(idProduct).get();
	}

	@Override
	public List<Produit> findProductByKeyWord(String kw) {
		return prodRepo.findProductByKeyWord(kw);
	}

	@Override
	public List<Produit> findProductByCategory(Long idCategorie) {
		return prodRepo.findProductByCategory(idCategorie);
	}

	@Override
	public List<Produit> findSelectedProducts() {
		return prodRepo.findSelectedProducts();
	}

	@Override
	public Commande enregistrerCommande(Panier panier, Client client) {
		Commande cmd = new Commande(new Date(), client, panier.getDictPannierProduit());
		comRepo.save(cmd);
		return cmd;
	}

	@Override
	public void saveCategorie(Categorie cat) {
		catRepo.save(cat);
	}

	@Override
	public void deleteCategorie(Categorie cat) {
		catRepo.delete(cat);
	}

	@Override
	public void updateCategorie(Categorie cat) {
		catRepo.save(cat);
	}

	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void attribuerRole(Role role, User user) {
		role.setUser(user);
		roleRepo.save(role);
	}
}
