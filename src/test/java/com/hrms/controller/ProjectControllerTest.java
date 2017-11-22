package com.hrms.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hrms.builder.ProjectListBuilder;
import com.hrms.controller.ProjectController;
import com.hrms.services.DepartmentService;
import com.hrms.services.ProjectService;


public class ProjectControllerTest {
	@Mock
    private ProjectService projectServiceMock;

    @Mock
    private DepartmentService departmentServiceMock;
    
    private MockMvc mockMvc;
    
    @InjectMocks
    private  ProjectController projectController;
    
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
 
    }
    
    @Test
    public void ListProjects_getAll() throws Exception {

    	ProjectListBuilder listBuilder = new ProjectListBuilder();

        when(projectServiceMock.getAll()).thenReturn(listBuilder.build());
        try {
           mockMvc.perform(get("/project/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("projectList"))
                //.andExpect(forwardedUrl("ListProjects"))
                .andExpect(model().attribute("projects", hasSize(2)));
        } catch (AssertionError e) {
			System.out.println("ListProject Error Message: " + e.getMessage());
			throw e;
	    }

        // verify EXACTLY 1 invocation ...
        verify(projectServiceMock, times(1)).getAll();
        verifyNoMoreInteractions(projectServiceMock);
    }
}
