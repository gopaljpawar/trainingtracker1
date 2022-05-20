package com.hcl.dashboard.controller;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.dashboard.domain.Budget;
import com.hcl.dashboard.domain.Dashboard;
import com.hcl.dashboard.domain.Hours;
import com.hcl.dashboard.domain.Status;
import com.hcl.dashboard.domain.Type;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

	@Autowired
	private RestTemplate restTemplate;
	
	 

	@GetMapping("/tottalNumberOFTrainigs")
	public ResponseEntity<String> getNumberOFTrainings() {
		List<Dashboard> dashboardlist = this.restTemplate.getForObject("http://localhost:9001/training/all",
				List.class);
		Long tottalNumberOFTrainigs = (long) dashboardlist.size();
		return new ResponseEntity<String>("Total number of training : " + tottalNumberOFTrainigs, HttpStatus.OK);
	}

	
	@GetMapping("/averagerating")
	public ResponseEntity<String> getAverageRating() {
		Dashboard ratings[] = this.restTemplate.getForObject("http://localhost:9001/training/all",
				Dashboard[].class);
		Float averageRating = 0.0f;
		int count = 0;
		for(Dashboard dbs : ratings) {
			averageRating+=dbs.getRating();
			count++;
		}
		averageRating=averageRating/count;
		return new ResponseEntity<String>("Average rating is : " + averageRating, HttpStatus.OK);
		
	}
	
	   @GetMapping("/totalhourstraining") 
		public ResponseEntity<?> getHourseOfTraining() {
			Hours totalhour[] = this.restTemplate.getForObject("http://localhost:9001/training/all",
					Hours[].class);
		
			 List<Hours> listhours = new ArrayList();
			for (Hours data : totalhour) {
				Hours hr = new Hours();
				/*
				 * Date date1 = data.getStartdate(); Date date2 =data.getEnddate() ; long
				 * time_difference = date2.getTime() - date1.getTime(); long hours_difference =
				 * (time_difference / (1000*60*60)) % 24;
				 */
				
		            hr.setCoursename(data.getCoursename());
				    hr.setHours(data.getHours());
				    hr.setStartdate(data.getStartdate());
				    hr.setEnddate(data.getEnddate());
				    listhours.add(hr);
				
			}
			return new ResponseEntity<List>(listhours, HttpStatus.OK);

		}
	   
	   
	   @GetMapping("/trainingstatus") 
	   public ResponseEntity<List> getTrainingStatus() {
		   Dashboard dashboard[] = this.restTemplate.getForObject("http://localhost:9001/training/all",
					Dashboard[].class);
		  
		   List<Status> list = new ArrayList();
		   for (Dashboard data: dashboard ) {
			   Status status =  new Status() ;
			   status.setId(data.getId());
			   status.setTrainingName(data.getCoursename());
			   status.setStatus(data.getStatus());
			   list.add(status);
			  
			}
		 
		   return new ResponseEntity<List>(list, HttpStatus.OK);
	   }
	   
	   
		 @GetMapping("/trainingtype") 
			public ResponseEntity<?> getTrainingType() {

				Type types[] = this.restTemplate.getForObject("http://localhost:9001/training/all", Type[].class);
				
				List<Type> list = new ArrayList();
				for (Type data : types) {
					Type type = new Type();
					type.setCoursename(data.getCoursename());
					type.setType(data.getType());
					list.add(type);
				}
				return new ResponseEntity<List>(list, HttpStatus.OK);

			}
	
	  @GetMapping("/budget") 
		public ResponseEntity<?> getBudget() {
			Budget budget[] = this.restTemplate.getForObject("http://localhost:9001/training/all", Budget[].class);
			

			List<Budget> list = new ArrayList();
			for (Budget data : budget) {
				Budget budgets = new Budget();
				budgets.setCoursename(data.getCoursename());
				budgets.setBudget(data.getBudget());
				list.add(budgets);
			}
			return new ResponseEntity<List>(list, HttpStatus.OK);
		}

	/* 
	 * @GetMapping("/monthlytrainingview") public String getMonthlyView() {
	 * 
	 * return null;
	 * 
	 * }
	 */

}
