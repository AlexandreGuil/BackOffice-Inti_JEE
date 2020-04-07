package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long>{

}
