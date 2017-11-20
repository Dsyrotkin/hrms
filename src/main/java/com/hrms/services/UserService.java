package com.hrms.services;

import com.hrms.domain.User;

public interface UserService {

	public User getUserByUsername(String username);
	public User save(User user);
	public User createUser(String username);
}
