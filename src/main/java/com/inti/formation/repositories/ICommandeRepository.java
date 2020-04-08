package com.inti.formation.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Commande;

@Repository("commandeRepository")
public interface ICommandeRepository extends JpaRepository<Commande, Long> {

	public Commande findByDateCommande(Date d);
	
}
