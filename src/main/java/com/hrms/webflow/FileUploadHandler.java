package com.hrms.webflow;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.execution.RequestContext;

import com.hrms.domain.Image;

public class FileUploadHandler implements Serializable{

	private static final long serialVersionUID = 6133859707732978112L;
	private MultipartFile file;

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public Image getImage(String employeeId, RequestContext requestContext) throws IOException {
		final ServletExternalContext context = (ServletExternalContext) requestContext.getExternalContext();
	    final MultipartHttpServletRequest multipartRequest = new StandardMultipartHttpServletRequest((HttpServletRequest)context.getNativeRequest());
	    final MultipartFile uploadedFile = multipartRequest.getFile("file");
		Image image = new Image();
		
		if (uploadedFile != null) {
            image.setFileName(employeeId + "_" + uploadedFile.getOriginalFilename());
            image.setData(uploadedFile.getBytes());
        }
  
        return image;
	}
	
}
