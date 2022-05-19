package com.hcl.training_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training_management.domain.Trainee;
@Repository
public interface TraineeRepository extends CrudRepository<Trainee, Long>{
	
	Trainee findByCoursename(String coursename);
	Iterable<Trainee> findAll();	

}
