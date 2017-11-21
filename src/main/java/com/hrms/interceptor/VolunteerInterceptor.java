package com.hrms.interceptor;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.util.GeneralHelper;

public class VolunteerInterceptor implements HandlerInterceptor{

@Autowired
private GeneralHelper helper;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
//		Principal principal = request.getUserPrincipal();
//		String userMessage = "Welcome to web security demo!";
//		if(request.isUserInRole("ROLE_ADMIN")) {
//			userMessage += " ROLE_ADMIN has extra 20% off!";
//		}
		
		request.setAttribute("user", helper.getPrincipal());
		return true;
	}

}