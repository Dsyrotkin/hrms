package com.hrms.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrms.domain.Department;
import com.hrms.domain.Project;
import com.hrms.services.DepartmentService;
import com.hrms.services.ProjectService;

@Component
public class ProjectNameIsExistValidator implements ConstraintValidator<ProjectNameIsExist, Project> {

	@Autowired
	private ProjectService projectService;

	@Override
	public void initialize(ProjectNameIsExist arg0) {
		
	}

	@Override
	public boolean isValid(Project project, ConstraintValidatorContext context) {
		if(projectService == null) {
			return true;
		}
		
		List<Project> projects = null;

		projects = projectService.getByName(project.getName());
		

		return projects == null ? true : false;
	}

}
