package com.hrms.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hrms.domain.Project;

public interface ProjectService {

	public List<Project> getAll();
	public Project save(Project p);
	public Project getById(Long id);
	public void remove(Long id);
	public List<Project> getByName(String name);
}
