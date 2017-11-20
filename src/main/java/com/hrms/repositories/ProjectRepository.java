package com.hrms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrms.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	//@Query("select p from Project p where LOWER(name) like '%:passedname%'")
	public List<Project> getByNameContainingIgnoreCase(String passedname);
}
