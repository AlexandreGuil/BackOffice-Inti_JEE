package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.IdLigneCommande;
import com.inti.formation.entities.LigneCommande;

public interface ILigneCommandeRepository extends JpaRepository<LigneCommande, IdLigneCommande> {

}
