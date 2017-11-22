package com.hrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.domain.Employee;
import com.hrms.domain.User;
import com.hrms.repositories.UserRepository;
import com.hrms.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		user.setPassword(user.getPassword());
		return userRepository.save(user);
	}

	@Override
	public User createUser(String username) {
		User user = new User(username);
		user.setPassword("test");
		user.setEnabled(true);
		return user;
	}

}
