package com.hrms.builder.dept;

import com.hrms.domain.Department;

public class DepartmentBuilder {
    private Department department;
    
	public DepartmentBuilder() {
		this.department = new Department();
	}

	
   public DepartmentBuilder withName(String name) {
       this.department.setName(name);
       
       return this;
   }
   
   public DepartmentBuilder withId(Long id) {
       this.department.setId(id);
       
       return this;
   }

   public Department build() {
       return department;
   }

}
