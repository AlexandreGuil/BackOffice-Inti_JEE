package com.inti.fromation.projetspring.ecommerce.repository;

import com.inti.fromation.projetspring.ecommerce.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILigneDeCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
