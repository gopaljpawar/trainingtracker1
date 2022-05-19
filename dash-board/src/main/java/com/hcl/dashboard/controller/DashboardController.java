package com.hcl.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.dashboard.domain.Dashboard;
import com.hcl.dashboard.domain.Status;
import com.hcl.dashboard.domain.Type;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
		public ResponseEntity<String> getHourseOfTraining() {
			Dashboard totalhour[] = this.restTemplate.getForObject("http://localhost:9001/training/all",
					Dashboard[].class);
			int totalhours = 0;
			for (Dashboard data : totalhour) {
				totalhours += data.getDuration();
			}
			return new ResponseEntity<String>("Total training hours is : " + totalhours, HttpStatus.OK);

		}
	   
	   
	   @GetMapping("/trainingstatus") 
	   public ResponseEntity<?> getTrainingStatus() {
		   Dashboard dashboard[] = this.restTemplate.getForObject("http://localhost:9001/training/all",
					Dashboard[].class);
		   Status status =  new Status() ;
		   List<Status> list = new ArrayList();
		   for (Dashboard data: dashboard ) {
			   status.setId(data.getId());
			   status.setTrainingName(data.getCoursename());
			   status.setStatus(data.getStatus());
			   list.add(status);
			}
		   return new ResponseEntity<List>(list, HttpStatus.OK);
	   }
	   
	   
		 @GetMapping("/trainingtype") 
		 public ResponseEntity<?> getTrainingType() {
		 
			 Dashboard dashboard[] = this.restTemplate.getForObject("http://localhost:9001/training/all",
						Dashboard[].class); 
		 Type type = new Type();
		  List<Type> list = new ArrayList();
		 for (Dashboard data: dashboard ) {
			   type.setTrainingName(data.getCoursename());
			   type.setType(data.getType());
			   list.add(type);
			}
		 return new ResponseEntity<List>(list, HttpStatus.OK);
		 
		  }
	/* 
	  @GetMapping("/budget") public Double getBudget() { Double totalBudget =
	  restTemplate.getForObject("http://localhost:9002/totalbudget", Double.class);
	  return totalBudget; }
	*/
	   
	 
	
	  /* 
	 * @GetMapping("/trainingtype") public Dashboard getTrainingType() {
	 * 
	 * Dashboard trainingTypes =
	 * restTemplate.getForObject("http://localhost:9002/typesoftraining",
	 * Dashboard.class); return trainingTypes;
	 * 
	 * }
	 * 
	 * @GetMapping("/monthlytrainingview") public String getMonthlyView() {
	 * 
	 * return null;
	 * 
	 * }
	 */

}
