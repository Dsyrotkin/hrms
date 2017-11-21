package com.hrms.services.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.domain.Image;
import com.hrms.repositories.ImageRepository;
import com.hrms.services.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image save(Image image) {
		return imageRepository.save(image);
	}
	
	@Override
	public Image getById(long id) {
		return imageRepository.findOne(id);
	}
	
	@Override
	public void uploadImageFile(Image image) {
		ByteArrayInputStream inputStream = null;
		FileOutputStream outputStream = null;
	    String fileName = image.getFileName();

	    String rootPath = System.getProperty("catalina.home");
	    File dir = new File(rootPath + File.separator + "webapp" + File.separator+ "resources" + File.separator + "img");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    File newFile = new File(dir.getAbsolutePath() + File.separator + fileName);
	    try {
	    	inputStream = new ByteArrayInputStream(image.getData());

	        if (!newFile.exists()) {
	            newFile.createNewFile();
	        }
	        outputStream = new FileOutputStream(newFile);
	        int read = 0;
	        byte[] bytes = new byte[1024];

	        while ((read = inputStream.read(bytes)) != -1) {
	            outputStream.write(bytes, 0, read);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
