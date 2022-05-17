package com.hcl.schedule_management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.schedule_management.domain.Schedule;
import com.hcl.schedule_management.repository.ScheduleRepository;
import com.hcl.schedule_management.service.ScheduleService;
@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	
	
	@Override
	public void addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
	scheduleRepository.save(null);
		
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Schedule> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Schedule schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Schedule Search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule advancedSearch(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}			

	

}
