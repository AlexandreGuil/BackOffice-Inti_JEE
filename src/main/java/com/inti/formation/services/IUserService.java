package com.inti.formation.services;

import java.util.List;

import com.inti.formation.entities.User;

public interface IUserService {
	
	/* ===================== CRUD ===================== */
	
	public List<User> findAllUser();
	public User findUserById(Long idUser);
	
	public User saveOrUpdateUser(User user);
	public void delete(User user);
	
	/* ===================== CRUD ===================== */
	
}
