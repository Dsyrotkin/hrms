package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hrms.services.RoleService;
import com.hrms.services.UserService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
}
