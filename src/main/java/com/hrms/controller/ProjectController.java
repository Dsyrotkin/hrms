package com.hrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrms.domain.Project;
import com.hrms.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);
		return "projectList";
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String project(@ModelAttribute("project") Project project) {
		return "projectForm";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String projectEdit(Model model, @PathVariable String id) {
		
		Project project = projectService.getById(Long.parseLong(id));
		model.addAttribute("project", project);
		return "projectForm";
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("project") Project project, BindingResult br, RedirectAttributes ra) {
		
		if(br.hasErrors()) {
			return "projectForm";
		}
		Project savedProject = projectService.save(project);
		
		ra.addFlashAttribute("project", savedProject);
		return "redirect:/project/success";
	}
	
	@RequestMapping(value="remove/{id}", method=RequestMethod.GET)
	public String remove(Model model, @PathVariable String id, RedirectAttributes ra) {
		
		projectService.remove(Long.parseLong(id));
		ra.addFlashAttribute("message", "Project deleted successfully");
		return "redirect:/project/list";
	}
	
	@RequestMapping(value="success", method=RequestMethod.GET)
	public String success() {
		return "projectSaved";
	}
	
}
