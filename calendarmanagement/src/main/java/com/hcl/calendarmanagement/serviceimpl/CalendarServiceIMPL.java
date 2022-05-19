package com.hcl.calendarmanagement.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendarmanagement.domain.Calendar;
import com.hcl.calendarmanagement.exception.CalendarIdException;
import com.hcl.calendarmanagement.repository.CalendarRepository;
import com.hcl.calendarmanagement.service.CalendarService;
@Service
public class CalendarServiceIMPL implements CalendarService {
	@Autowired
	private CalendarRepository calendarRepository;

	@Override
	public Calendar save(Calendar calendar) {
		calendar.setName(calendar.getName().toUpperCase());
		return calendarRepository.save(calendar);
	}
	@Override
	public Iterable<Calendar> list() {	
		return calendarRepository.findAll();
	}

	@Override
	public void deleteCalendar(Long id) {
		Optional<Calendar> calendar =calendarRepository.findById(id);
		if(calendar==null) {
			throw new CalendarIdException("the name of calendar is not found");
		}
		calendarRepository.deleteById(id);;
	}
	@Override
	public Calendar findCalendar(String name) {
		return calendarRepository.findByName(name);
		
	}

}
