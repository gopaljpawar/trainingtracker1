package com.hcl.calendar_management.repository;

import com.hcl.calendar_management.domain.Meeting;

public interface MeetingRepository {
	
	Meeting  findByTringBatchIdentifier(String tringBatchIdentifier);

}
