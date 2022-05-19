package com.hcl.calendar_management.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	private String identifier;
	private Long eventId;
	private String description;
	private Date start_Date;
	private Date end_Date;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "calendar_name")
	@JsonIgnore
	private Calendar calendar;
   
	
	
	public Event() {
		super();
	}
	


	public Event(Long id, String name, String tringBatchIdentifier, String description, Date start_Date,
			Date end_Date) {
		super();
		this.id = id;
		this.name = name;
		this.identifier =identifier;
		this.description = description;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
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


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String Identifier) {
		this.identifier = identifier;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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



	public Calendar getCalendar() {
		return calendar;
	}



	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}



	public Long getEventId() {
		return eventId;
	}



	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	




	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", identifier=" + identifier + ", eventId=" + eventId
				+ ", description=" + description + ", start_Date=" + start_Date + ", end_Date=" + end_Date
				+ ", calendar=" + calendar + "]";
	}
	
	
	
	
	
	
	

}
