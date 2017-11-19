package com.hrms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.services.DepartmentService;
import com.hrms.domain.Department;
import com.hrms.repositories.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {

		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(Long id) {

		return departmentRepository.findOne(id);
	}

	@Override
	public void deleteDepartment(Long id) {

		departmentRepository.delete(id);
	}

	@Override
	public Department SaveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartmentsByName(String name) {

		return departmentRepository.getDepartmentsLikeName(name);
	}

}
