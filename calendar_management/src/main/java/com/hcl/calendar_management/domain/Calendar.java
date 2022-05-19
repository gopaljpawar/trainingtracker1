package com.hcl.calendar_management.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Calendar {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	
	
	private Long ScheduleId;
	@Column(name="calendar_name")
	private String identifier;
	private Date start_Date;
	private Date end_Date;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "calendar")
	List<Event> event=  new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "calender")
	List<Meeting> meeting=new ArrayList<>();
		
	
	//@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	// @JoinColumn(name = "schedule_id", referencedColumnName = "id")
	/*
	private List<Schedule> schedule=new ArrayList<>();
    public Calendar() {
		super();
	}
	
	public Calendar(Long id, Long scheduleId, String identifier, Date start_Date, Date end_Date, List<Event> event,
			List<Schedule> schedule) {
		super();
		this.id = id;
		ScheduleId = scheduleId;
		this.identifier = identifier;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.event = event;
		this.schedule = schedule;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}





	public Long getScheduleId() {
		return ScheduleId;
	}





	public void setScheduleId(Long scheduleId) {
		ScheduleId = scheduleId;
	}
	

	public List<Meeting> getMeeting() {
		return meeting;
	}

	public void setMeeting(List<Meeting> meeting) {
		this.meeting = meeting;
	}


/*
	public List<Schedule> getSchedule() {
		return schedule;
	}




	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}















	@Override
	public String toString() {
		return "Calendar [id=" + id + ", ScheduleId=" + ScheduleId + ", identifier=" + identifier + ", start_Date="
				+ start_Date + ", end_Date=" + end_Date + ", event=" + event + ", schedule=" + schedule + "]";
	}
	*/




}
