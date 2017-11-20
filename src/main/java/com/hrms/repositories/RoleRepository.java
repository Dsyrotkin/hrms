package com.hrms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	public Role findByName(String name);
}
