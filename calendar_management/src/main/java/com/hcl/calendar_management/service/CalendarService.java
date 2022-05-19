package com.hcl.calendar_management.service;

import com.hcl.calendar_management.domain.Calendar;

public interface CalendarService {
	
	void save(Calendar calendar);
	void Edit(Calendar calendar);
	void delete(Long id);

}
