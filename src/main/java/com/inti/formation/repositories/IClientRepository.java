package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Client;

@Repository("clientRepository")
public interface IClientRepository extends JpaRepository<Client, Long> {

}