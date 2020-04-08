package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Categorie;

@Repository("catRepo")
public interface ICategorieRepository extends JpaRepository<Categorie, Long> {
	
}