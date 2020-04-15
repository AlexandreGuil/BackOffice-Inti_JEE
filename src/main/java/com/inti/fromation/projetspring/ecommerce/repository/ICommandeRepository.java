package com.inti.fromation.projetspring.ecommerce.repository;


import com.inti.fromation.projetspring.ecommerce.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {
}
