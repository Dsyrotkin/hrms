package com.hrms.builder;

import com.hrms.domain.Role;
import com.hrms.domain.User;

public class UserBuilder {
	  private User user;
	    
		public UserBuilder() {
			this.user = new User();
		}

		
	   public UserBuilder withUserName(String username) {
	       this.user.setUsername(username);
	       return this;
	   }
	   
	   public UserBuilder withId(Long id) {
	       this.user.setId(id);
	       return this;
	   }

	   public User build() {
	       return user;
	   }
}
