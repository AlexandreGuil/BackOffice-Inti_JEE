//package com.inti.formation.services.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.inti.formation.entities.Role;
//import com.inti.formation.entities.User;
//import com.inti.formation.repositories.IRoleRepository;
//import com.inti.formation.services.IRoleService;
//
//@Service("roleService")
//public class RoleService implements IRoleService {
//	
//	@Autowired
//	@Qualifier("roleRepository")
//	private IRoleRepository repo;
//
//	@Override
//	public void attributeRole(Role role, User user) {
//		role.setUsers(user);
//		repo.save(role);
//	}
//	
//	
//
//}
