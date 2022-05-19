package com.hcl.calendar_management.controller;

import java.util.ArrayList;
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

import com.hcl.calendar_management.domain.Calendar;
import com.hcl.calendar_management.domain.Schedule;
import com.hcl.calendar_management.repository.CalendarRepository;
import com.hcl.calendar_management.serviceimpl.CalendarServiceIMPL;
import com.hcl.calendar_management.serviceimpl.MapValidationErrorService;



@RestController
@RequestMapping("/calendar")
public class CalendarController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CalendarServiceIMPL calendarService;
	@Autowired
	private MapValidationErrorService mves;
	@PostMapping("/new")
	 public ResponseEntity<?> createCalendar(@Valid @RequestBody Calendar calendar,BindingResult result){
		 ResponseEntity<?> errorMap= mves.mapValidationError(result);
			if(errorMap!=null)return errorMap;
			//List<Schedule> schedule= restTemplate.getForObject("http://localhost:3306/api/schedules"+calendar.getScheduleId(), List.class);
			//calendar.setSchedule(schedule);
			Calendar newCalendar=calendarService.save(calendar);
			return new  ResponseEntity<Calendar>(newCalendar,HttpStatus.CREATED);
	 }
	

	@GetMapping("/{identifier}")
	public ResponseEntity<?> getCalendarById(@PathVariable String identifier){
		Calendar calendar=calendarService.findByIdentifier(identifier);
		return new ResponseEntity<Calendar>(calendar,HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Calendar> listAll(){
		return calendarService.list();
		
	}
	@DeleteMapping("/{identifier}")
	public ResponseEntity<?> deleteCalendar(@PathVariable String identifier){
		calendarService.deleteCalendar(identifier);
		
		return new ResponseEntity<String>("Calendar has deleted of identifier is  "+identifier,HttpStatus.OK);
		
	}
	

}
