package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.IdLigneCommande;
import com.inti.formation.entities.LigneCommande;

@Repository("ligneCommandeRepository")
public interface ILigneCommandeRepository extends JpaRepository<LigneCommande, IdLigneCommande> {
	
	public LigneCommande findByIdLigneDeCommande(IdLigneCommande IdLCmd);
	
}
