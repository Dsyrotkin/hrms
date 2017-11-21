package com.hrms.services.impl;

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

}
