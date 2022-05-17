package com.hcl.dashboard.domain;

public class Dashboard {
	
	private Long tottalNumberOFTrainigs;
	private Long averagerating;
	private Long totalhourstraining;
	private Double budget;
	private String trainingstatus;
	private String trainingtype;
	private Long monthlytrainingview;
	
	public Long getTottalNumberOFTrainigs() {
		return tottalNumberOFTrainigs;
	}
	public void setTottalNumberOFTrainigs(Long tottalNumberOFTrainigs) {
		this.tottalNumberOFTrainigs = tottalNumberOFTrainigs;
	}
	public Long getAveragerating() {
		return averagerating;
	}
	public void setAveragerating(Long averagerating) {
		this.averagerating = averagerating;
	}
	public Long getTotalhourstraining() {
		return totalhourstraining;
	}
	public void setTotalhourstraining(Long totalhourstraining) {
		this.totalhourstraining = totalhourstraining;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getTrainingstatus() {
		return trainingstatus;
	}
	public void setTrainingstatus(String trainingstatus) {
		this.trainingstatus = trainingstatus;
	}
	public String getTrainingtype() {
		return trainingtype;
	}
	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}
	public Long getMonthlytrainingview() {
		return monthlytrainingview;
	}
	public void setMonthlytrainingview(Long monthlytrainingview) {
		this.monthlytrainingview = monthlytrainingview;
	}
	
}


