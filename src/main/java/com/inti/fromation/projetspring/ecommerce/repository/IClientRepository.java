package com.inti.fromation.projetspring.ecommerce.repository;


import com.inti.fromation.projetspring.ecommerce.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
    public Client findByNomClientAndAdresseAndTel(String nomClient, String Adresse, String tel);
}
