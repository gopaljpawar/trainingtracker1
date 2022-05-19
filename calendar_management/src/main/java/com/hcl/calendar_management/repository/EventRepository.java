package com.hcl.calendar_management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.hcl.calendar_management.domain.Event;
import com.hcl.calendar_management.domain.Meeting;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	//List<Event>  findByIdentifier(String identifier);

	//Event findByName(String id);

	//Event findByIdentifier(String id, String name)

	Event findByName(String name);

	Event findByIdentifier(String identifier);

	Event findByEventId(Long id);

}
