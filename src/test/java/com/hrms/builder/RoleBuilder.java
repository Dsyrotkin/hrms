package com.hrms.builder;

import com.hrms.domain.Role;

public class RoleBuilder {
    private Role role;
    
	public RoleBuilder() {
		this.role = new Role();
	}

	
   public RoleBuilder withName(String name) {
       this.role.setName(name);
       return this;
   }
   
   public RoleBuilder withId(Long id) {
       this.role.setId(id);
       return this;
   }

   public Role build() {
       return role;
   }

}
