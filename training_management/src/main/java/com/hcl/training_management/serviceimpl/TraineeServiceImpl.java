package com.hcl.training_management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training_management.Exception.TraineeIdException;
import com.hcl.training_management.domain.Trainee;
import com.hcl.training_management.repository.TraineeRepository;
import com.hcl.training_management.service.TraineeService;
@Service
public class TraineeServiceImpl implements TraineeService{
@Autowired
private TraineeRepository traineeRepository;

@Override
public Trainee saveOrUpdate(Trainee trainee) {
	try {
		trainee.setCoursename(trainee.getCoursename().toUpperCase());
		return traineeRepository.save(trainee);
		}catch(Exception ex) {
		throw new TraineeIdException("Trainee Id:" +trainee.getCoursename().toUpperCase()+"already exists");
		}
		}


@Override
public Trainee findTraineeByCoursename(String coursename) {
	Trainee trainee = traineeRepository.findByCoursename(coursename.toUpperCase());
	if(trainee==null) {
	throw new TraineeIdException("Coursename:" +coursename.toUpperCase()+"Doesnot Exist");
	}
	return trainee;
	}


@Override
public Iterable<Trainee> findAllTrainee() {
	return traineeRepository.findAll();
}

@Override
public void deleteTraineeByCoursename(String coursename) {
	Trainee trainee = traineeRepository.findByCoursename(coursename.toUpperCase());
	if(trainee==null) {
	throw new TraineeIdException("Course name :"+coursename.toUpperCase()+"Does not exist");
	}
	traineeRepository.delete(trainee);

	}
}

	




