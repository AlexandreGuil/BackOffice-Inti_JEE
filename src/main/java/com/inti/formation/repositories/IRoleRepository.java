package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Role;
import com.inti.formation.entities.User;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Integer> {
	
	public User findUserByRoleName(String roleName);
	
}
