package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Role;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Long> {
	
}
