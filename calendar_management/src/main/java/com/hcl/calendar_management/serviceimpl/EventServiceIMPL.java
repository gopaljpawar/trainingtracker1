package com.hcl.calendar_management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendar_management.domain.Calendar;
import com.hcl.calendar_management.domain.Event;
import com.hcl.calendar_management.domain.Meeting;
import com.hcl.calendar_management.exception.CalendarIdException;
import com.hcl.calendar_management.repository.CalendarRepository;
import com.hcl.calendar_management.repository.EventRepository;
import com.hcl.calendar_management.service.EventService;
@Service
public class EventServiceIMPL implements EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CalendarRepository calendarRepository;
		
	@Override
	public Event save(Event event, String id) {
		
		Calendar calendar=calendarRepository.findByIdentifier(id);
		System.out.println(calendar);
		if(calendar==null) {
			throw new CalendarIdException("calendar identifier  "+id+"  is not found");
		}
		event.setCalendar(calendar);
		event.setIdentifier(id);
		event.setName(event.getName());
		return eventRepository.save(event);
		
	}

	
	@Override
	public Iterable<Event> list() {
		
		
		
		return  eventRepository.findAll();

	}
	@Override
	public Event findByNameIdentifier(String identifier,String name) {
		Calendar calendar=calendarRepository.findByIdentifier(identifier);
		Event event=eventRepository.findByName(name);
		return event;
	}


	/*@Override
	public void  delete(String idendifier,String name) {
		Event event=findByNameIdentifier(idendifier,name.toUpperCase());
		Calendar calendar=event.getCalendar();
		List<Event> events=calendar.getEvent();
		events.remove(event);
		calendarRepository.save(calendar);
		eventRepository.delete(event);
		
		

	}*/
	@Override
	public void delete(Long id) {
		
			Event event= eventRepository.findByEventId(id);
			if(event==null) {
				throw new CalendarIdException("event identifier  "+id+"  is not found");
			}
			eventRepository.delete(event);


	

	}

	

}
