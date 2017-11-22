package com.hrms.builder;

import com.hrms.domain.Project;

public class ProjectBuilder {
	 private Project project;
	    
	 	public ProjectBuilder() {
			this.project = new Project();
		}

	 	
//	    public ProjectBuilder withCategory(Category category) {
//	        this.project.setCategory(category);
//	        return this;
//	    }

	    public ProjectBuilder withName(String name) {
	        this.project.setName(name);
	        return this;
	    }


	    public ProjectBuilder withDescription(String description) {
	        this.project.setDescription(description);
	        return this;
	    }

	    public ProjectBuilder withId(Long id) {
	        this.project.setId(id);
	        return this;
	    }

	    public Project build() {
	        return project;
	    }
}
