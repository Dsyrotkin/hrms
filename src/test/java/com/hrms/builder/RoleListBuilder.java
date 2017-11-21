package com.hrms.builder;

import java.util.Arrays;
import java.util.List;

import com.hrms.domain.Role;

public class RoleListBuilder {

	public RoleBuilder roleBuilder1 = new RoleBuilder().withId(1L).withName("ROLE_ADMIN");
	public RoleBuilder roleBuilder2 = new RoleBuilder().withId(2L).withName("ROLE_USER");

	public List<Role> build() {

		Role first = roleBuilder1.build();
		Role second = roleBuilder2.build();
		return (List<Role>) Arrays.asList(first, second);
	}
	
	public RoleBuilder getRoleBuilder1() {
		return roleBuilder1;
	}

	public RoleBuilder getRoleBuilder2() {
		return roleBuilder2;
	}
}
