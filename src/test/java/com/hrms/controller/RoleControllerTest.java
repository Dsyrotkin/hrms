package com.hrms.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.builder.RoleBuilder;
import com.hrms.builder.RoleListBuilder;
import com.hrms.builder.UserBuilder;
import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.services.RoleService;
import com.hrms.services.UserService;


public class RoleControllerTest {
	   @Mock
	    private RoleService roleServiceMock;

	    @Mock
	    private UserService userServiceMock;

    private MockMvc mockMvc;
   
    @InjectMocks
    private  RoleController roleController;

    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
    }
    
    
    @Test
    public void addRole_Post() throws Exception {
    	   Role role = new RoleBuilder()
    	            .withId(1L)
    	             .withName("ROLE_TEST")
    	            .build();
    	   
    	 	try {
     			mockMvc.perform(post("/admin/role/addRole")
    			    .param("name", "ROLE_TEST"))
    			    .andExpect(status().is3xxRedirection())
    			    .andExpect(redirectedUrl("/admin/role"))
    			    // validate that Data binding has worked...compare ModelAttribute (NewProduct)
    			    // with "real" values....
    			    ;
    		} catch (AssertionError e) {
    			System.out.println("SaveProduct Error Message: " + e.getMessage());
    			throw e;
    		}
    }
    
    @Test
    public void getUsersByRole() throws Exception {
    	
    	List<Role> roles = new RoleListBuilder().build();
    	User user = new UserBuilder().withId(1L).withUserName("test").withPassword("test").withRoles(roles).build();
    	String rolename = "ROLE_ADMIN";
    	when(roleServiceMock.getUsersByRoleName(rolename)).thenReturn(Arrays.asList(user));
    	  
          mockMvc.perform(get("/admin/role/"+rolename))
                  .andExpect(status().isOk())
                  //.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                  .andExpect(jsonPath("$[0].id", is(1)))
                  .andExpect(jsonPath("$[0].username", is("test")))
                  .andExpect(jsonPath("$[0].password", is("test")));
    }
    
    
//    @Test
//    public void addUserRole() throws Exception {
//    List<Role> roles = new RoleListBuilder().build();
//    Role role = new RoleBuilder().withId(3L).withName("ROLE_TEST").build();
//   	User user = new UserBuilder().withId(1L).withUserName("test").withPassword("test").withRoles(roles).build();
//		// studentService.addCourse to respond back with mockCourse
//		when(userServiceMock.save(any(User.class))).thenReturn(user);
//		when(userServiceMock.getUserByUsername(user.getUsername())).thenReturn(user);
//		when(roleServiceMock.getByName("ROLE_TEST")).thenReturn(role);
//		String Json = "{\"username\":\"test\",\"roleName\":\"ROLE_TEST\"}";
//
//	       mockMvc.perform(post("/admin/role/addUserRole").contentType(MediaType.APPLICATION_JSON).content(Json))
//           .andExpect(status().isOk())
//           .andExpect(jsonPath("$[0].id", is(1)))
//           .andExpect(jsonPath("$[0].username", is("test")))
//           .andExpect(jsonPath("$[0].password", is("test")));
//    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
