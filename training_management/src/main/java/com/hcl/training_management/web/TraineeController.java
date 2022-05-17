package com.hcl.training_management.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training_management.domain.Trainee;
import com.hcl.training_management.service.TraineeService;
import com.hcl.training_management.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/training")
public class TraineeController {
@Autowired
private TraineeService traineeService;
@Autowired
private MapValidationErrorService mapValidationErrorService;
@PostMapping("")
public ResponseEntity<?> createNewTrainee(@Valid @RequestBody Trainee trainee,BindingResult result) {
ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
if(errorMap!=null)return errorMap;
Trainee savedTrainee = traineeService.saveOrUpdate(trainee);
return new ResponseEntity<Trainee>(savedTrainee,HttpStatus.CREATED);
}

@GetMapping("/all")
public Iterable<Trainee> getAllTrainee(){
return traineeService.findAllTrainee();
}
@GetMapping("/{coursename}")
public ResponseEntity<?> getTraineeById(@PathVariable String coursename){
Trainee trainee = traineeService.findTraineeByCoursename(coursename);
return new ResponseEntity<Trainee>(trainee,HttpStatus.OK);
}
@DeleteMapping("/{coursename}")
public ResponseEntity<?> deleteTrainee(@PathVariable String coursename){
traineeService.deleteTraineeByCoursename(coursename);
return new ResponseEntity<String>("Trainee with Id:"+coursename.toUpperCase()+"Deleted Successfully",HttpStatus.OK);
}
}


