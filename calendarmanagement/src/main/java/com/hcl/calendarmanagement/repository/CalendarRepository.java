package com.hcl.calendarmanagement.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.calendarmanagement.domain.Calendar;
@Repository
public interface CalendarRepository  extends CrudRepository<Calendar, Long>{
	
	Calendar findByName(String name);

}
