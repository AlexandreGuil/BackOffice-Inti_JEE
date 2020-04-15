package com.inti.fromation.projetspring.ecommerce.repository;


import com.inti.fromation.projetspring.ecommerce.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategorieRepository extends JpaRepository<Categorie, Long> {
    
}
