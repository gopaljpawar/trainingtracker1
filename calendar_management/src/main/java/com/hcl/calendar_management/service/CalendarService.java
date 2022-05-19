package com.hcl.calendar_management.service;

import com.hcl.calendar_management.domain.Calendar;


public interface CalendarService {
	
	Calendar save(Calendar calendar);
	Calendar findByIdentifier(String identifier);
	Iterable<Calendar> list();
	void deleteCalendar(String identifier);

}
