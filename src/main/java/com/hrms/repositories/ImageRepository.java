package com.hrms.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long>{

}
