package com.hrms.services;

import java.util.List;

import com.hrms.domain.Project;

public interface ProjectService {

	public List<Project> getAll();
	public Project save(Project p);
	public Project getById(Long id);
}
