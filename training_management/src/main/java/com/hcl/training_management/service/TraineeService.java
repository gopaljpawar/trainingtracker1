package com.hcl.training_management.service;

import java.util.List;

import com.hcl.training_management.domain.Trainee;



public interface TraineeService {
	public Trainee saveOrUpdate(Trainee trainee);
	public Trainee findTraineeByCoursename(String coursename);
	public Iterable<Trainee>findAllTrainee();
	public void deleteTraineeByCoursename(String coursename);
	

}
