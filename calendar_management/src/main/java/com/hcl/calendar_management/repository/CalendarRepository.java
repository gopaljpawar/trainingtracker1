package com.hcl.calendar_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.calendar_management.domain.Calendar;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
	

}
