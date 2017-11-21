package com.hrms.builder.dept;

import java.util.Arrays;
import java.util.List;

import com.hrms.domain.Department;

public class DepartmentListBuilder {

	public DepartmentBuilder deptBuilder1 = new DepartmentBuilder().withId(1L).withName("IT");
	public DepartmentBuilder deptBuilder2 = new DepartmentBuilder().withId(2L).withName("SALES");

	public List<Department> build() {

		Department first = deptBuilder1.build();
		Department second = deptBuilder2.build();
		
		return (List<Department>) Arrays.asList(first, second);
	}
	
	public DepartmentBuilder getDepartmentBuilder1() {
		return deptBuilder1;
	}

	public DepartmentBuilder getDepartmentBuilder2() {
		return deptBuilder2;
	}
}
