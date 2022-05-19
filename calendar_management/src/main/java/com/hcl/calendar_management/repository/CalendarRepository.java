package com.hcl.calendar_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.calendar_management.domain.Calendar;
@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Long> {

	Calendar findByIdentifier(String identifier);

	
}
