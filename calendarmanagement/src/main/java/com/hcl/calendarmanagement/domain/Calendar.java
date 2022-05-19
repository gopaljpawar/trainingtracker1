package com.hcl.calendarmanagement.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	String event;
	private  Date eventStartDate;
	private  Date eventendDate;
	String meeting;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "calendar")	
    List<Event> events=  new ArrayList<>();
    @JsonIgnore
	public Calendar() {
		super();
	}
	public Calendar(Long id, String name, String event, Date eventStartDate, Date eventendDate,
			String meeting) {
		super();
		this.id = id;
		this.name = name;
		this.event = event;
		this.eventStartDate = eventStartDate;
		this.eventendDate = eventendDate;
		this.meeting = meeting;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Date getEventendDate() {
		return eventendDate;
	}
	public void setEventendDate(Date eventendDate) {
		this.eventendDate = eventendDate;
	}
	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	
	

}
