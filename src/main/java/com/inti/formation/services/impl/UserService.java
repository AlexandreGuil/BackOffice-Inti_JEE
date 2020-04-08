package com.inti.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inti.formation.entities.User;
import com.inti.formation.repositories.IUserRepository;
import com.inti.formation.services.IUserService;

public class UserService implements IUserService {
	
	@Autowired
	@Qualifier("userRepository")
	private IUserRepository repo;

	@Override
	public List<User> findAllUser() {
		return repo.findAll();
	}

	@Override
	public User findUserById(Long idUser) {
		return repo.findById(idUser).get();
	}

	@Override
	public User saveOrUpdateUser(User user) {
		repo.save(user);
		return user;
	}

	@Override
	public void delete(User user) {
		repo.delete(user);	
	}
}
