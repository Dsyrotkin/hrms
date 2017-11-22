package com.hrms.webflow;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.domain.Image;

public class FileUploadHandler implements Serializable{

	private static final long serialVersionUID = 6133859707732978112L;
	private transient MultipartFile file;

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public Image getImage(String employeeId) throws IOException {
		Image image = new Image();
		
		if (file != null) {
            image.setFileName(employeeId + "_" + file.getOriginalFilename());
            image.setData(file.getBytes());            
        }
  
        return image;
	}
	
}
