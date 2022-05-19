package com.hcl.calendarmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.calendarmanagement.domain.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	Event findByName(String name);

}
