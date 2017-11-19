package com.hrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.domain.User;
import com.hrms.repositories.UserRepository;
import com.hrms.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	
	
	

}
