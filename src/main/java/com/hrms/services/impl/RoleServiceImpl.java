package com.hrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.repositories.UserRepository;
import com.hrms.services.RoleService;
@Service 
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private UserRepository userRepository;
	
	

}
