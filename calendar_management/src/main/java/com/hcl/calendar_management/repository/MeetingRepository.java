package com.hcl.calendar_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.calendar_management.domain.Event;
import com.hcl.calendar_management.domain.Meeting;
@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long>{
	
	

	Meeting findByName(String name);

	Meeting findByIdentifier(String identifier);
	Meeting findByMeetingId(Long id);
	
}
