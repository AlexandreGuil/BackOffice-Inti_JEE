package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Categorie;

public interface ICategorieRepository extends JpaRepository<Categorie, Long> {

}