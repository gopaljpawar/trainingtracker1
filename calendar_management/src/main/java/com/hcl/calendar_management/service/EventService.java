package com.hcl.calendar_management.service;

import com.hcl.calendar_management.domain.Event;

public interface EventService {
	
	void save(Event event);
	void list(Long id);
	void delete(Long id);

}
