package com.hcl.schedule_management.controller;

import java.util.List;

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
import org.springframework.web.client.RestTemplate;

import com.hcl.schedule_management.domain.Schedule;
import com.hcl.schedule_management.domain.Trainee;
import com.hcl.schedule_management.service.ScheduleService;
import com.hcl.schedule_management.serviceimpl.MapValidationErrorService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("")
	public ResponseEntity<?> creatNewSchedule(@Valid @RequestBody Schedule schedule, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		Schedule savedSchedule= scheduleService.saveOrUpdate(schedule);
		return new ResponseEntity<Schedule>(savedSchedule, HttpStatus.CREATED);
	}
	
	@GetMapping("/{scheduleId}")
	public ResponseEntity<?> getScheduleById(@PathVariable Long scheduleId){
		Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId);
		return new ResponseEntity<Schedule>(schedule, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Trainee> getAllSchedule(){
	//Trainee trainee = restTemplate.getForObject("http://localhost:9001/training/all" , Trainee.class);
	
//	Trainee trainee [] = this.restTemplate.getForObject("http://localhost:9001/training/all",
//			Trainee[].class);
	Iterable<Trainee> trainees=restTemplate.getForObject("http://localhost:9001/training/all", List.class);
//	Trainee.setContact(contacts);
	
	
	return trainees;
		
		//return scheduleService.findAllSchedule();
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSchedule(@PathVariable Long id){
		scheduleService.deleteScheduleById(id);
		return new ResponseEntity<String>("Schedule with id :"+ id +" deleted successfully", HttpStatus.OK);
	}
	

	
	
	
}
