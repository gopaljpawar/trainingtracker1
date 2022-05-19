package com.hcl.calendar_management.domain;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String tringBatchIdentifier;
	private Date meetingDate;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "calendar_id", referencedColumnName = "id")
	private Calendar calendar;
	@JsonFormat()
	//private Time meetingtime;
	private String meetingStartTime;
	private String meetingEndingTime;
	
	
	public Meeting() {
		super();
	}
	

	public Meeting(Long id, String name, String description, String tringBatchIdentifier, Date meetingDate,
			String meetingStartTime, String meetingEndingTime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tringBatchIdentifier = tringBatchIdentifier;
		this.meetingDate = meetingDate;
		this.meetingStartTime = meetingStartTime;
		this.meetingEndingTime = meetingEndingTime;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTringBatchIdentifier() {
		return tringBatchIdentifier;
	}

	public void setTringBatchIdentifier(String tringBatchIdentifier) {
		this.tringBatchIdentifier = tringBatchIdentifier;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(String meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public String getMeetingEndingTime() {
		return meetingEndingTime;
	}

	public void setMeetingEndingTime(String meetingEndingTime) {
		this.meetingEndingTime = meetingEndingTime;
	}

//	public Time getMeetingtime() {
//		return meetingtime;
//	}
//
//	public void setMeetingtime(Time meetingtime) {
//		this.meetingtime = meetingtime;
//	}
//	
	
	
	
	

}
