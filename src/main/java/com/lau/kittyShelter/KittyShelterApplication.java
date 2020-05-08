package com.lau.kittyShelter;

import com.lau.kittyShelter.service.ShelterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KittyShelterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyShelterApplication.class, args);
		ShelterService shelterService = new ShelterService();
		System.out.println(shelterService.isThereNewKittiesYet());
		System.out.println(shelterService.isThereNewKittiesYet()); // mocking schedule for now
	}

}
