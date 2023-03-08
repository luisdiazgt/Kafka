package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.model.User;
import com.example.kafka.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	@Autowired
	KafKaProducerService producerService;

	@PostMapping(value = "/text")
	public ResponseEntity<?> sendMessageToKafkaTopic(@RequestBody String message) {
		this.producerService.sendMessage(message);
		return ResponseEntity.ok().body("true");		
	}
	
	@PostMapping(value = "/entity")
	public ResponseEntity<?> sendMessageToKafkaTopic(@RequestBody User user) {
		
		// User user = new User();
		// user.setUserId(userId);
		// user.setFirstName(firstName);
		// user.setLastName(lastName);
		
		this.producerService.saveCreateUserLog(user);
		return ResponseEntity.ok().body("true");
	}
    
}
