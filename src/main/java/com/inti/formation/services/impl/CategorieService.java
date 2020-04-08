package com.inti.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Categorie;
import com.inti.formation.repositories.ICategorieRepository;
import com.inti.formation.services.ICategorieService;

@Service(value = "categorieService")
public class CategorieService implements ICategorieService {
	
	@Autowired
	@Qualifier(value = "categorieRepository")
	private ICategorieRepository repo;
	
	@Override
	public List<Categorie> findAllCategorie() {
		return repo.findAll();
	}

	@Override
	public Categorie fingByIdCategorie(Long idCategorie) {
		return repo.findById(idCategorie).get();
	}

	@Override
	public Categorie saveOrUpdateCategorie(Categorie categorie) {
		repo.save(categorie);
		return categorie;
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		repo.delete(categorie);
	}

}
