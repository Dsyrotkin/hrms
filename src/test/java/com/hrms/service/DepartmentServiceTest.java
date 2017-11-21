package com.hrms.service;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hrms.builder.dept.DepartmentListBuilder;
import com.hrms.domain.Department;
import com.hrms.repositories.DepartmentRepository;
import com.hrms.services.impl.DepartmentServiceImpl;

public class DepartmentServiceTest {
	@Mock
	private DepartmentRepository deptRepositoryMock;

	@InjectMocks
	private DepartmentServiceImpl deptService;

	DepartmentListBuilder builder;

	List<Department> deptList = new ArrayList<Department>();

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		builder = new DepartmentListBuilder();
		deptList = builder.build();
	}

	@Test
	public void getUsersByDepartmentName() {

	}

	@Test
	public void getAll() {
		when(deptRepositoryMock.findAll()).thenReturn(deptList);
		List<Department> departments = deptService.getAllDepartments();

		Department object1 = builder.getDepartmentBuilder1().build();
		Department object2 = builder.getDepartmentBuilder2().build();
		
		assertThat(departments,
				hasItem(allOf(hasProperty("id", is(object1.getId())), hasProperty("name", is(object1.getName())))));

		assertThat(departments,
				hasItem(allOf(hasProperty("id", is(object2.getId())), hasProperty("name", is(object2.getName())))));

	}

	@Test
	public void getByName() {
		String name = "IT";

		when(deptRepositoryMock.getByName(name)).thenReturn(deptList.get(0));
		
		Department object1 = builder.getDepartmentBuilder2().build();
		Department department = deptService.getByName(name);
		assertThat(department,
				allOf(hasProperty("id", is(object1.getId())), hasProperty("name", is(object1.getName()))));
	}

	@Test
	public void save() {

	}

	@Test
	public void delete() {

	}
}
