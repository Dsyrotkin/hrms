package com.hrms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
