package com.hrms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.repositories.RoleRepository;
import com.hrms.repositories.UserRepository;
import com.hrms.services.RoleService;
@Service 
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsersByRoleName(String rolename){
		return userRepository.getUsersByRolename(rolename);
	}

	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}
	

}
