package com.hcl.calendar_management.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Calendar {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="tring_Batch")
	@NotBlank
	private String traningBatch;
	
	private String tringBatchIdentifier;
	private Date start_Date;
	private Date end_Date;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "calendar")
	
	List<Event> event=  new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "calendar")
    
    List<Meeting> meeting=new ArrayList<>();
	
	
    public Calendar() {
		super();
	}
	

	public Calendar(@NotBlank String traningBatch, String tringBatchIdentifier, Date start_Date, Date end_Date) {
		super();
		this.traningBatch = traningBatch;
		this.tringBatchIdentifier = tringBatchIdentifier;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTraningBatch() {
		return traningBatch;
	}

	public void setTraningBatch(String traningBatch) {
		this.traningBatch = traningBatch;
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

	public List<Meeting> getMeeting() {
		return meeting;
	}

	public void setMeeting(List<Meeting> meeting) {
		this.meeting = meeting;
	}

	public String getTringBatchIdentifier() {
		return tringBatchIdentifier;
	}

	public void setTringBatchIdentifier(String tringBatchIdentifier) {
		this.tringBatchIdentifier = tringBatchIdentifier;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", traningBatch=" + traningBatch + ", tringBatchIdentifier="
				+ tringBatchIdentifier + ", start_Date=" + start_Date + ", end_Date=" + end_Date + ", event=" + event
				+ ", meeting=" + meeting + "]";
	}
	
	
	
	
}
