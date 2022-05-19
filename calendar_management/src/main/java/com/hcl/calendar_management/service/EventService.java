package com.hcl.calendar_management.service;

import com.hcl.calendar_management.domain.Event;

public interface EventService {
	
	Event save(Event event, String Id);
	Iterable<Event> list();
	Event findByNameIdentifier(String Id, String name);
	void delete(Long id);
	
	
	

}
