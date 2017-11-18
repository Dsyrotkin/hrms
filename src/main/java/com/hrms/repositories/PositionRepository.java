package com.hrms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.domain.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>{

}
