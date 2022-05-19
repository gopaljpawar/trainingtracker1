package com.hcl.calendarmanagement.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendarmanagement.domain.Calendar;
import com.hcl.calendarmanagement.domain.Event;
import com.hcl.calendarmanagement.exception.CalendarIdException;
import com.hcl.calendarmanagement.repository.CalendarRepository;
import com.hcl.calendarmanagement.repository.EventRepository;
import com.hcl.calendarmanagement.service.EventService;
@Service
public class EventServiceIMPL implements EventService {
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CalendarRepository calendarRepository;
	@Override
	public Event addEvent(Event event, String id) {
		Calendar calendar=calendarRepository.findByName(id);
		event.setCalendar(calendar);
		return eventRepository.save(event);
	}
	@Override
	public Iterable<Event> list() {
		return eventRepository.findAll();
	}
	@Override
	public void deleteEvent(String name) {
		
	Event event=	eventRepository.findByName(name);
		if(event==null) {
			throw new CalendarIdException("the name of event is not found");
		}
		eventRepository.delete(event);
		
		
	}

	
}
