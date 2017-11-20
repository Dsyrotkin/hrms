package com.hrms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hrms.domain.Project;
import com.hrms.repositories.ProjectRepository;
import com.hrms.services.ProjectService;

@Service

public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public Project save(Project p) {
		// TODO Auto-generated method stub
		return projectRepository.save(p);
	}

	@Override
	public Project getById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.findOne(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		projectRepository.delete(id);		
	}

	@Override
	public List<Project> getByName(String name) {
		// TODO Auto-generated method stub
		return projectRepository.getByNameContainingIgnoreCase(name);
		
	}
	
	

}
