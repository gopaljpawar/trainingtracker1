package com.hcl.calendarmanagement.service;

import com.hcl.calendarmanagement.domain.Event;

public interface EventService {
	
  
	Event addEvent(Event event,String id);
	Iterable<Event> list();
	void deleteEvent(String name);

}
