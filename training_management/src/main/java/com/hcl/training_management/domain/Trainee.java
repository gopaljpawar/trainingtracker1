package com.hcl.training_management.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trainee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank(message="name required")
private String name;
@NotBlank(message="type required")
private String type;
@NotBlank(message="status required")
private String status;
private String phnno;
private String email;
// @NotBlank(message="trainer name required")
private String trainername;
@NotBlank(message="coursename required")
@Column(updatable=false,unique=true)
private String coursename;

private Long Duration;
@JsonFormat(pattern="yyyy-mm-dd")
private Date startdate;
@JsonFormat(pattern="yyyy-mm-dd")
private Date enddate;



public Trainee() {
super();
// TODO Auto-generated constructor stub
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
@Override
public String toString() {
return "Trainee [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", phnno=" + phnno
+ ", email=" + email + ", coursename=" + coursename + "]";
}
public String getTrainername() {
return trainername;
}
public void setTrainername(String trainername) {
this.trainername = trainername;
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
public String getCoursename() {
return coursename;
}
public void setCoursename(String coursename) {
this.coursename = coursename;
}
public Long getDuration() {
	return Duration;
}
public void setDuration(Long duration) {
	Duration = duration;
}

}