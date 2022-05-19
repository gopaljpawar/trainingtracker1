package com.hcl.dashboard.domain;

public class Status {
	
	private Long id;
	private String trainingName;
	private String status;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Status() {
		super();
	}
	public Status(Long id, String trainingName, String status) {
		super();
		this.id = id;
		this.trainingName = trainingName;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

}
