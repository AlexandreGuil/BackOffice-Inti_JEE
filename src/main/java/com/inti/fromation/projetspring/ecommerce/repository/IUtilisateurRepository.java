package com.inti.fromation.projetspring.ecommerce.repository;

import com.inti.fromation.projetspring.ecommerce.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
