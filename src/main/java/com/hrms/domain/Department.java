package com.hrms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.hrms.validator.DeptNameIsExist;

@Entity
@Table(name="DEPARTMENT")
@DeptNameIsExist
public class Department implements Serializable {
	
	private static final long serialVersionUID = 8884341285809650039L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@NotBlank(message= "{Dept.NAME.REQUIRED}")
	@Column(name = "NAME")
	private String name;
	
    @NotBlank(message= "{Dept.Desc.REQUIRED}")
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	private Set<Employee> employees ;
	
	@OneToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	private Set<Project> projects ;
	
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
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public Set<Project> getProjects() {
		return projects;
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
}
