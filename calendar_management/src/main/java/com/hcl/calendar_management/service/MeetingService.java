package com.hcl.calendar_management.service;

import com.hcl.calendar_management.domain.Meeting;

public interface MeetingService {
	Meeting save(Meeting meeting, String Id);
	Iterable<Meeting> list();
	Meeting findByNameIdentifier(String Id, String name);
	
	void delete(Long id);

}
