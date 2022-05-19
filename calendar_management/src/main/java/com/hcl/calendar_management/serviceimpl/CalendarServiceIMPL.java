package com.hcl.calendar_management.serviceimpl;

import com.hcl.calendar_management.domain.Calendar;
import com.hcl.calendar_management.domain.Meeting;
import com.hcl.calendar_management.repository.CalendarRepository;
import com.hcl.calendar_management.repository.MeetingRepository;
import com.hcl.calendar_management.service.CalendarService;

public class CalendarServiceIMPL implements CalendarService {
	
	private CalendarRepository calendarRepository;
	private MeetingRepository meetingRepository;

	@Override
	public void save(Calendar calendar) {
		Meeting meeting =new Meeting();
		//calendar.setMeeting(meetingRepository.findByTringBatchIdentifier(null));
		calendarRepository.save(calendar);

	}

	@Override
	public void Edit(Calendar calendar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
