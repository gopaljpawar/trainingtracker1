package com.hcl.calendar_management.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@NotBlank
	private String tringBatchIdentifier;
	private String description;
	private Date start_Date;
	private Date end_Date;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "calendar_id",referencedColumnName = "id")
	private Calendar calendar;
	
	
	public Event() {
		super();
	}
	


	public Event(Long id, String name, String tringBatchIdentifier, String description, Date start_Date,
			Date end_Date) {
		super();
		this.id = id;
		this.name = name;
		this.tringBatchIdentifier = tringBatchIdentifier;
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


	public String getTringBatchIdentifier() {
		return tringBatchIdentifier;
	}


	public void setTringBatchIdentifier(String tringBatchIdentifier) {
		this.tringBatchIdentifier = tringBatchIdentifier;
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
	
	
	
	
	

}
