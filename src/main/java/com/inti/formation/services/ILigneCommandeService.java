package com.inti.formation.services;

import java.util.List;

import com.inti.formation.entities.IdLigneCommande;
import com.inti.formation.entities.LigneCommande;

public interface ILigneCommandeService {
	
	/* ===================== CRUD ===================== */
	
	public List<LigneCommande> findAllLigneDeCommande();
	public LigneCommande findByIdLigneDeCommande(IdLigneCommande IdLCmd);
	
	public LigneCommande saveOrUpdateLigneDeCommande(LigneCommande lcmd);
	public void deleteLignedeCommande(LigneCommande lcmd);
	
	/* ===================== CRUD ===================== */
	
}
