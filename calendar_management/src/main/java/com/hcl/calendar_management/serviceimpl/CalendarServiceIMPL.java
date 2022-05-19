package com.hcl.calendar_management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendar_management.domain.Calendar;
import com.hcl.calendar_management.domain.Event;
import com.hcl.calendar_management.domain.Meeting;
import com.hcl.calendar_management.exception.CalendarIdException;
import com.hcl.calendar_management.repository.CalendarRepository;
import com.hcl.calendar_management.repository.MeetingRepository;
import com.hcl.calendar_management.service.CalendarService;
@Service
public class CalendarServiceIMPL implements CalendarService {
	@Autowired
	private CalendarRepository calendarRepository;


	@Override
	public Calendar save(Calendar calendar) {
		
		//calendar.setMeeting(meetingRepository.findByTringBatchIdentifier(null));
		
		
		return calendarRepository.save(calendar);

	}

	@Override
	public Calendar findByIdentifier(String identifier) {
		Calendar calendar=calendarRepository.findByIdentifier(identifier);
		if(calendar==null) {
			throw new CalendarIdException("calendar idenifier  :"+identifier.toUpperCase()+"  not found");
		}
		return calendar;
	}

	@Override
	public Iterable<Calendar> list() {
		
		return calendarRepository.findAll();
	}

	@Override
	public void deleteCalendar(String identifier) {
		Calendar calendar=calendarRepository.findByIdentifier(identifier);
		if(calendar==null) {
			throw new CalendarIdException("calendar idenifier  :"+identifier.toUpperCase()+"  not found");
		}
		calendarRepository.delete(calendar);
		
	}

}
