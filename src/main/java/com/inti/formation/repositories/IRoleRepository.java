package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
