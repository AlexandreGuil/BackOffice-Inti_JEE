package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {

}
