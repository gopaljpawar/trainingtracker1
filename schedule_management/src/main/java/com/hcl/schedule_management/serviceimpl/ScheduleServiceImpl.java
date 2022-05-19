package com.hcl.schedule_management.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.schedule_management.domain.Schedule;
import com.hcl.schedule_management.exception.ScheduleIdException;
import com.hcl.schedule_management.repository.ScheduleRepository;
import com.hcl.schedule_management.service.ScheduleService;
@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Schedule saveOrUpdate(Schedule schedule) {
		
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule findScheduleByScheduleId(Long id) {
		Schedule schedule = scheduleRepository.findScheduleById(id);
		if (schedule==null) {
			throw new ScheduleIdException("Schedule with ID :"+schedule.getId()+" is not found");
		}
		return schedule;
	}

	@Override
	public Iterable<Schedule> findAllSchedule() {
		// TODO Auto-generated method stub
		return scheduleRepository.findAll();
		
	}

	@Override
	public void deleteScheduleById(Long id) {
		Schedule schedule= scheduleRepository.findScheduleById(id);
		if(schedule==null) {
			throw new ScheduleIdException("Schedule with ID :"+schedule.getId()+" is not found");
			
		}
		scheduleRepository.delete(schedule);
	}

}
