package com.hcl.dashboard.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Dashboard {
	private Long id;
	private String name;
	private String type;
	private String status;
	private String phnno;
	private String email;
	private String trainername;
	private String coursename;
	private Float rating;
	public Float getRating() {
		return rating;
	}
	public Dashboard(Long id, String name, String type, String status, String phnno, String email, String trainername,
			String coursename, Float rating, Long duration, Date startdate, Date enddate) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.phnno = phnno;
		this.email = email;
		this.trainername = trainername;
		this.coursename = coursename;
		this.rating = rating;
		this.duration = duration;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}

	private Long duration;
	private Date startdate;
	private Date enddate;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhnno() {
		return phnno;
	}
	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
		
	public Dashboard() {
		
	}
	
}


