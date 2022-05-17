package com.hcl.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

	@GetMapping("/tottalNumberOFTrainigs")
	public Long getNumberOFTrainings() {

		return null;

	}

	@GetMapping("/averagerating")
	public Long getAverageRating() {

		return null;

	}

	@GetMapping("/totalhourstraining")
	public Long getHourseOfTraining() {

		return null;

	}

	@GetMapping("/budget")
	public Double getBudget() {

		return null;

	}

	@GetMapping("/trainingstatus")
	public String getTrainingStatus() {

		return "Completed";

	}

	@GetMapping("/trainingtype")
	public String getTrainingType() {

		return null;

	}

	@GetMapping("/monthlytrainingview")
	public Long getMonthlyView() {

		return null;

	}

}
