package com.harjeet.SpringRsocket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class PatientController {

	@GetMapping("get-patient-date")
	public Mono<ClinicalData> requestResponse(Patient pt){
		return Mono.just(new ClinicalData(90,"80/120"));
		
	}
}
