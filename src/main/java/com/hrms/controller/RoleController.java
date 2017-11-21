package com.hrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.domain.rest.AddUserRole;
import com.hrms.domain.rest.Test;
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
	
	
	@RequestMapping(value = "/admin/role/addRole", method = RequestMethod.GET)
	public String addRolePage(@ModelAttribute("role") Role role, Model model) {
		model.addAttribute("roles",roleService.getAll());
		return "addRoleForm";
	}
	
	@RequestMapping(value = "/admin/role/addRole", method = RequestMethod.POST)
	public String addRolePost(@Valid @ModelAttribute("role") Role role, BindingResult result, Model model,RedirectAttributes rAttributes) {
		if(result.hasErrors())
		{
			return "addRoleForm";
		}
		
		roleService.save(role);
		return "redirect:/admin/role";
	}
	
	
	
	@RequestMapping(value = "/admin/role/{rolename}", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsersByRole(@PathVariable("rolename") String rolename) {
		List<User> users = roleService.getUsersByRoleName(rolename);
		return  users;
	}
	
	@RequestMapping(value = "/admin/role/addUserRole", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	public @ResponseBody ResponseEntity<User> addRoleToUser(@Valid @RequestBody AddUserRole userRole,Model model) {
		User user = userService.getUserByUsername(userRole.getUsername());
		if(user != null) {
			if(user.getRoles().stream().anyMatch(r -> userRole.getRoleName().equals(r.getName())))
			{
				return new ResponseEntity<>(user,HttpStatus.CONFLICT);
			}
			Role role = roleService.getByName(userRole.getRoleName());
			
			user.getRoles().add(role);
			return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value = "/admin/role/delete/{username}", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	public @ResponseBody ResponseEntity<User> deleteUserRole(@RequestBody Role role,@PathVariable("username") String username ,Model model) {
		User user = userService.getUserByUsername(username);
		if(user != null) {
			user.getRoles().removeIf((r) -> role.getName().equals(r.getName()));
			return new ResponseEntity<>( userService.save(user) ,HttpStatus.OK);
		}
		return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/admin/role/deleteRole", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	public @ResponseBody ResponseEntity<Role> deleteRole(@RequestBody Role role, Model model) {
		Role dbRes = roleService.getByName(role.getName());
		if(dbRes != null)
		{
			roleService.delete(dbRes.getId());
			return new ResponseEntity<>( role ,HttpStatus.OK);
		}
		
		return new ResponseEntity<>( role ,HttpStatus.BAD_REQUEST);
	}
	
	
}
