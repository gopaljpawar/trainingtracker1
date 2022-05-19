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
import com.hcl.calendar_management.domain.Meeting;
import com.hcl.calendar_management.serviceimpl.CalendarServiceIMPL;
import com.hcl.calendar_management.serviceimpl.MapValidationErrorService;
import com.hcl.calendar_management.serviceimpl.MeetingServiceIMPL;

@RestController
@RequestMapping("/calendar/meeting")
public class MeetingController {
	
	@Autowired
	private CalendarServiceIMPL calendarService;
	@Autowired
	private MeetingServiceIMPL meetingService;
	@Autowired
	private MapValidationErrorService mves;
	
	@PostMapping("/new/{identifier}")
	public ResponseEntity<?> saveEvent(@Valid @RequestBody Meeting meeting, BindingResult result,@PathVariable String identifier){
		
		ResponseEntity<?> errorMap= mves.mapValidationError(result);
		if(errorMap!=null)return errorMap;
		Meeting meetings=meetingService.save(meeting, identifier);
		return new  ResponseEntity<Meeting>(meetings,HttpStatus.CREATED);
		
	}
	@GetMapping("/all")
	public Iterable<Meeting> getEventofCalendar(){
		
		return meetingService.list();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMeeting(@PathVariable Long  id){
		meetingService.delete(id);
		return new ResponseEntity<String> ("event name  :  "+id+"  Deleted Succefully",HttpStatus.OK);
	}

}
