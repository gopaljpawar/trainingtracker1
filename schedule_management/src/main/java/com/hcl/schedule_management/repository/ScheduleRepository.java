package com.hcl.schedule_management.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.schedule_management.domain.Schedule;
@Repository
public interface ScheduleRepository  extends CrudRepository<Schedule, Long>{
	
Schedule findScheduleById(Long id);
	
	Iterable<Schedule> findAll();
}
