package com.hcl.calendar_management.controller;

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

import com.hcl.calendar_management.domain.Event;
import com.hcl.calendar_management.serviceimpl.CalendarServiceIMPL;
import com.hcl.calendar_management.serviceimpl.EventServiceIMPL;
import com.hcl.calendar_management.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/calendar/event")
public class EventController {
	@Autowired
	private CalendarServiceIMPL calendarService;
	@Autowired
	private EventServiceIMPL eventService;
	@Autowired
	private MapValidationErrorService mves;
	
	@PostMapping("/new/{identifier}")
	public ResponseEntity<?> saveEvent(@Valid @RequestBody Event event, BindingResult result,@PathVariable String identifier){
		
		ResponseEntity<?> errorMap= mves.mapValidationError(result);
		if(errorMap!=null)return errorMap;
		Event newEvent=eventService.save(event, identifier);
		return new  ResponseEntity<Event>(newEvent,HttpStatus.CREATED);
		
	}
	@GetMapping("/all")
	public Iterable<Event> getEventofCalendar(){
		
		return eventService.list();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMeeting(@PathVariable Long  id){
		eventService.delete(id);
		return new ResponseEntity<String> ("event name  :  "+id+"  Deleted Succefully",HttpStatus.OK);
	}


	
	

}
