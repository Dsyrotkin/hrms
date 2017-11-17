package com.hrms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrms.util.GeneralHelper;

@Controller
public class HomeController {

	@Autowired
	private GeneralHelper helper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home(Model model) {
	model.addAttribute("user", helper.getPrincipal());
		return "welcome";
	}
	
}
