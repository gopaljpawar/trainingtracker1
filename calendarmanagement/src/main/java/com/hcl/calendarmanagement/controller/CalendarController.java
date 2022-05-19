package com.hcl.calendarmanagement.controller;

import java.util.Optional;

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

import com.hcl.calendarmanagement.domain.Calendar;
import com.hcl.calendarmanagement.service.CalendarService;
import com.hcl.calendarmanagement.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private MapValidationErrorService mves;
	@PostMapping("/save")
	public ResponseEntity<?> createCalendar(@Valid @RequestBody Calendar calendar , BindingResult result){
		ResponseEntity<?> errorMap=mves.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Calendar calendars=calendarService.save(calendar);
		return new ResponseEntity<Calendar>(calendars,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public Iterable<Calendar> seeAll(){
		return calendarService.list();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCalendar(@PathVariable Long id){
		calendarService.deleteCalendar(id);
		return new ResponseEntity<String>("calendar has been deleted ",HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findaCalendar(@PathVariable String id){
		Calendar calendar=calendarService.findCalendar(id);
		return new ResponseEntity<Calendar>(calendar,HttpStatus.OK);
	}

}
