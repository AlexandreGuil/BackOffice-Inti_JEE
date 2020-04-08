package com.inti.formation.services;

import java.util.List;

import com.inti.formation.entities.Role;
import com.inti.formation.entities.User;

public interface IRoleService {
	
	/* ===================== CRUD ===================== */
	
	public List<Role> findAllRole();
	public Role findRoleById(Integer idRole);
	
	/* ===================== CRUD ===================== */
	
	public User findUserByRoleName(String roleName);
	public void attributeRole(Role role, User user);
	
}
