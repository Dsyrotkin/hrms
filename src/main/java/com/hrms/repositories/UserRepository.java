package com.hrms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findUserByUsername(String username);
	
	@Query("SELECT u FROM User u INNER JOIN u.roles r WHERE r.name = ?1")
	public List<User> getUsersByRolename(String rolename);

}
