package com.inti.formation.services;

import java.util.List;

import com.inti.formation.entities.Categorie;

public interface ICategorieService {
	
	/* ===================== CRUD ===================== */
	
	public List<Categorie> findAllCategorie();
	public Categorie fingByIdCategorie(Long idCategorie);
	
	public Categorie saveOrUpdateCategorie(Categorie categorie);
	public void deleteCategorie(Categorie categorie);
	
	/* ===================== CRUD ===================== */
}
