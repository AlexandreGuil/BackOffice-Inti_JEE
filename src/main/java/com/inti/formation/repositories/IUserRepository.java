package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long>{
	
}
