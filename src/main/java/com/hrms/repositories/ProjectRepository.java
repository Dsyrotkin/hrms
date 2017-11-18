package com.hrms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

}
