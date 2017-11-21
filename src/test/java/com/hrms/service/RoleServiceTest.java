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

import com.hrms.builder.RoleListBuilder;
import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.repositories.RoleRepository;
import com.hrms.services.impl.RoleServiceImpl;


public class RoleServiceTest {
	@Mock
	private RoleRepository roleRepositoryMock;

	// Needs to be class NOT interface - how can you inject into an Interface?
	@InjectMocks
	private RoleServiceImpl roleService;

	RoleListBuilder builder;

	List<Role> roleList = new ArrayList<Role>();

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		builder = new RoleListBuilder();
		roleList = builder.build();
	}

	@Test
	public void getUsersByRoleName() {

		
	}

	@Test
	public void getAll() {
		when(roleRepositoryMock.findAll()).thenReturn(roleList);
		List<Role> roles = roleService.getAll();

		Role object1 = builder.getRoleBuilder1().build();
		Role object2 = builder.getRoleBuilder2().build();
		assertThat(roles, hasItem(
                allOf(
                     hasProperty("id", is(object1.getId())),
                		hasProperty("name", is(object1.getName()))
                )
        ));
		
		assertThat(roles, hasItem(
                allOf(
                     hasProperty("id", is(object2.getId())),
                		hasProperty("name", is(object2.getName()))
                )
        ));
		
	}

	@Test
	public void getByName() {
		String name = "ROLE_ADMIN";
		when(roleRepositoryMock.findByName(name)).thenReturn(roleList.get(0));
		Role object1 = builder.getRoleBuilder1().build();
		Role role = roleService.getByName(name);
		assertThat(role,
                allOf(
                     hasProperty("id", is(object1.getId())),
                		hasProperty("name", is(object1.getName()))
                ));
	}

	@Test
	public void save() {

	}

	@Test
	public void delete() {

	}
}
