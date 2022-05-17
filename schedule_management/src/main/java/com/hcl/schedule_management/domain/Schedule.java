package com.hcl.schedule_management.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Employee or Traineer Name Reqired")
	private String name;
	@JsonFormat
	private Date scheduleDate;
	@NotBlank(message = "description is required")
	private String description;
	
//	private String batchName;			//from TM
//	private String batchIdentifier;		// from TM
//	private String Status;				// from TM
	
	private Date Started_Date;
	private Date End_Date;
		
	public Schedule() {
		super();
	}

	public Schedule(Long id, String name, Date scheduleDate, String description, Date started_Date, Date end_Date) {
		super();
		this.name = name;
		this.scheduleDate = scheduleDate;
		this.description = description;
		Started_Date = started_Date;
		End_Date = end_Date;
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

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStarted_Date() {
		return Started_Date;
	}

	public void setStarted_Date(Date started_Date) {
		Started_Date = started_Date;
	}

	public Date getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}
	@PrePersist
	public void onCreated() {
		this.Started_Date= new Date();
			
	}
//	@PostPersist
	public void onEnd() {
		this.End_Date= new Date();
	}
	
}
