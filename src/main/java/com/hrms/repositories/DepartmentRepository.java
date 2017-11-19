package com.hrms.repositories;
import com.hrms.domain.*;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
	
	@Query("SELECT U FROM Department U WHERE LOWER(U.name) LIKE %:name1%)")
	public List<Department> getDepartmentsLikeName(@Param("name1") String name);
	
	

}
