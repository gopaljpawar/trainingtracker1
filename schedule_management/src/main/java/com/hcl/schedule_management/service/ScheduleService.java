package com.hcl.schedule_management.service;

import java.util.List;

import com.hcl.schedule_management.domain.Schedule;

public interface ScheduleService {

	void addSchedule(Schedule schedule);
	void updateSchedule(Schedule schedule);
	List<Schedule> listAll();
	void delete(Schedule schedule);
	Schedule Search(String name);
	Schedule advancedSearch(String id, String name);
	
	
	
}
