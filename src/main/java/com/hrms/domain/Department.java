package com.hrms.domain;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private long id;
	private String name;
	private String description;
	private List<Position> positions = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	
	public Department() {}
	
	public Department(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Position> getPositions() {
		return positions;
	}
	
	public void addPosition(Position position) {
		positions.add(position);
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
}
