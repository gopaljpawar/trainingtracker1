package com.hcl.calendarmanagement.controller;

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

import com.hcl.calendarmanagement.domain.Event;
import com.hcl.calendarmanagement.service.EventService;
import com.hcl.calendarmanagement.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/calendar/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private MapValidationErrorService mves;
	@PostMapping("/save/{id}")
	public ResponseEntity<?> addEvents(@Valid @RequestBody Event event,BindingResult result,@PathVariable String id){
		ResponseEntity<?> errorMap= mves.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Event events=eventService.addEvent(event, id);
		return new ResponseEntity<Event> (events,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public Iterable<Event> getaAll(){
		return  eventService.list();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		eventService.deleteEvent(id);
		return new ResponseEntity<String>("event is deleted successfully",HttpStatus.OK);
	}

}
