package com.hcl.calendar_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CalendarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarManagementApplication.class, args);
	}
	/*@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

}
