package com.hrms.services;

import java.util.List;

import com.hrms.domain.Department;

public interface DepartmentService {
	
	public List<Department> getAllDepartments();
	public Department getDepartment(Long id);
	public void deleteDepartment(Long id);
	public Department SaveDepartment(Department department);
	public Department updateDepartment(Department department);
	

}
