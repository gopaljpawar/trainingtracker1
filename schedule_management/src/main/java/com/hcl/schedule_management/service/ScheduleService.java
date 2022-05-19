package com.hcl.schedule_management.service;

import com.hcl.schedule_management.domain.Schedule;

public interface ScheduleService {
	
	public Schedule saveOrUpdate(Schedule schedule);
	public Schedule findScheduleByScheduleId(Long id);
	public Iterable<Schedule> findAllSchedule();
	public void deleteScheduleById(Long id);
	
	
	
}
