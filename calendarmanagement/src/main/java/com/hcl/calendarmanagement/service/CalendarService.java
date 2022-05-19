package com.hcl.calendarmanagement.service;

import java.util.Optional;

import com.hcl.calendarmanagement.domain.Calendar;

public interface CalendarService {
	Calendar save(Calendar calendar);
	Iterable<Calendar> list();
	void deleteCalendar(Long id);
	Calendar findCalendar(String name);


}
