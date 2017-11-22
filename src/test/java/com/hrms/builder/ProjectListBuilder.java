package com.hrms.builder;

import java.util.Arrays;
import java.util.List;

import com.hrms.domain.Project;


public class ProjectListBuilder {
	public ProjectBuilder projectBuilderOne = new ProjectBuilder()
            .withId(1L)
//            .withCategory(new CategoryBuilder()
//                    .withId(1)
//                    .withName("Sports")
//                   .build())
            .withDescription("Two wheels")
            .withName("Bicycle");

	public ProjectBuilder projectBuilderTwo = new ProjectBuilder()
            .withId(2L)
//            .withCategory(new CategoryBuilder()
//            .withId(2)
//            .withName("Solids")
//           .build())
            .withDescription("6 sides")
            .withName("Cube");

	public List<Project> build() {
		
	    Project first = projectBuilderOne.build();	
	    Project second = projectBuilderTwo.build();
 	    return (List<Project>) Arrays.asList(first, second);
	}
	
	public  ProjectBuilder getProjectBuilderOne() {
		return projectBuilderOne;
	}
}
