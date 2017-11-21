package com.hrms.domain.rest;

import org.hibernate.validator.constraints.NotEmpty;

import com.hrms.validator.IsUserRoleExist;
import com.hrms.validator.UserShouldExist;

@IsUserRoleExist
public class AddUserRole {
	@NotEmpty
	@UserShouldExist
	private String username;
	@NotEmpty
	private String roleName;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
