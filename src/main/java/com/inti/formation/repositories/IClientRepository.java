package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}