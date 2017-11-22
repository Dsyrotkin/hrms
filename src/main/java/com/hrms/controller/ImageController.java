package com.hrms.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.domain.Image;
import com.hrms.services.ImageService;

@Controller
public class ImageController {

	@Autowired
	ImageService imageService;
	
	@RequestMapping(value="**/getPhoto/{id}")
	public void getUserImage(HttpServletResponse response , @PathVariable("id") long id) throws IOException{

		response.setContentType("image/jpeg");
		Image image = imageService.getById(id);
		String fileName = image.getFileName();
		String rootPath = System.getProperty("catalina.home");
		File photo = new File(rootPath + File.separator + "webapp" + File.separator + "resources" + File.separator + "img" + File.separator + fileName);
		InputStream in = new ByteArrayInputStream(Files.readAllBytes(photo.toPath()));
		IOUtils.copy(in, response.getOutputStream());
		
	}
	
}
