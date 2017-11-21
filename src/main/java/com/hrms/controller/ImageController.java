package com.hrms.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.services.ImageService;

@Controller
public class ImageController {

	@Autowired
	ImageService imageService;
	
	@RequestMapping(value="/employee/getPhoto/{id}")
	public void getUserImage(HttpServletResponse response , @PathVariable("id") long id) throws IOException{

	 response.setContentType("image/jpeg");
	  byte[] buffer = imageService.getById(id).getData();
	  InputStream in = new ByteArrayInputStream(buffer);
	  IOUtils.copy(in, response.getOutputStream());        
	}
	
}
