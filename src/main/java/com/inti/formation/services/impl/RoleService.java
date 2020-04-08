package com.inti.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Role;
import com.inti.formation.entities.User;
import com.inti.formation.repositories.IRoleRepository;
import com.inti.formation.services.IRoleService;

@Service("roleService")
public class RoleService implements IRoleService {
	
	@Autowired
	@Qualifier("roleRepository")
	private IRoleRepository repo;
	
	@Override
	public List<Role> findAllRole() {
		return repo.findAll();
	}

	@Override
	public Role findRoleById(Integer idRole) {
		return repo.findById(idRole).get();
	}

	@Override
	public User findUserByRoleName(String roleName) {
		return repo.findUserByRoleName(roleName);
	}
	
	/**
	 * 
	 * public void attributeRole(Role role, User user)
	 * 
	 * set a role to an user
	 * 
	 */
	
	@Override
	public void attributeRole(Role role, User user) {
		role.setUser(user);
		repo.save(role);
	}
}
