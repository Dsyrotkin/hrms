package com.hrms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
