package com.hrms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.util.GeneralHelper;

@Component
public class DepartmentDeleteInterceptor implements HandlerInterceptor {
	
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

		
		if(!request.isUserInRole("ROLE_ADMIN")) {
			arg1.setStatus(401);
			return false;
		}
		
		
		return true;
		
		
	}
	
}