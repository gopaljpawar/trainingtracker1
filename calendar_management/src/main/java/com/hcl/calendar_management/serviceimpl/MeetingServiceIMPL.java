package com.hcl.calendar_management.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendar_management.domain.Calendar;
import com.hcl.calendar_management.domain.Event;
import com.hcl.calendar_management.domain.Meeting;
import com.hcl.calendar_management.exception.CalendarIdException;
import com.hcl.calendar_management.repository.CalendarRepository;
import com.hcl.calendar_management.repository.EventRepository;
import com.hcl.calendar_management.repository.MeetingRepository;
import com.hcl.calendar_management.service.MeetingService;
@Service
public class MeetingServiceIMPL implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;
	@Autowired
	private EventRepository eventRepository;
	@Override
	public Meeting save(Meeting meeting, String id) {
		
		Event event=eventRepository.findByIdentifier(id);
		System.out.println(event);
		if(event==null) {
			throw new CalendarIdException("event identifier  "+id+"  is not found");
		}
		//meeting.setEvent(event);
		meeting.setIdentifier(id);
		meeting.setMeetingId(meeting.getId());
		return meetingRepository.save(meeting);

	}

	@Override
	public Iterable<Meeting> list() {
		
		return  meetingRepository.findAll();
	}
	@Override
	public Meeting findByNameIdentifier(String identifier, String name) {
		//Calendar calendar=calendarRepository.findByIdentifier(identifier);
		//Meeting meeting=meetingRepository.findByName(name);
		//return meeting;
		return null;
	}

	

	@Override
	public void delete(Long id) {
		
			Meeting meeting= meetingRepository.findByMeetingId(id);
			if(meeting==null) {
				throw new CalendarIdException("meeting identifier  "+id+"  is not found");
			}
			meetingRepository.delete(meeting);
			//if(meeting==null) {
			//	throw new ScheduleIdException("Schedule with ID :"+schedule.getId()+" is not found");
			//}

	}

	
}




