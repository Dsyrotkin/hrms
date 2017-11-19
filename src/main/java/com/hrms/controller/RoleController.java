package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.domain.response.Test;
import com.hrms.services.RoleService;
import com.hrms.services.UserService;
import com.hrms.util.GeneralHelper;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GeneralHelper helper;
	
	@RequestMapping(value = "/admin/role", method = RequestMethod.GET)
	public String addUserRolePage(Model model) {
		model.addAttribute("roles",roleService.getAll());
		return "role";
	}
	
	
	@RequestMapping(value = "/admin/role/add", method = RequestMethod.GET)
	public String addRolePage(Model model) {
		model.addAttribute("roles",roleService.getAll());
		return "role";
	}
	
	@RequestMapping(value = "/admin/role/add", method = RequestMethod.POST)
	public String addRolePost(Model model) {
		model.addAttribute("roles",roleService.getAll());
		return "role";
	}
	
	
	
	@RequestMapping(value = "/admin/role/{rolename}", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsersByRole(@PathVariable("rolename") String rolename) {
		List<User> users = roleService.getUsersByRoleName(rolename);
		return  users;
	}
	
	@RequestMapping(value = "/admin/role/add/{username}", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	public @ResponseBody ResponseEntity<User> addRoleToUser(@RequestBody Role role,@PathVariable("username") String username ,Model model) {
		User user = userService.getUserByUsername(username);
		if(user != null) {
			user.getRoles().add(role);
			return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
		}
		return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
	}
	
	
}
