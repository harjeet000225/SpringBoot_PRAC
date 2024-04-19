package com.harjeet.test;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.harjeet.dao.PaymentService;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	PaymentService service;
	
	@Test
	void contextLoads() {
	}

}