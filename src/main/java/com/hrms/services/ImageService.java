package com.hrms.services;

import com.hrms.domain.Image;

public interface ImageService{
	
	public Image save(Image image);
	public Image getById(long id);
	public void uploadImageFile(Image image);

}
