package com.harjeet.SpringJMS;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJmsApplicationTests {
	
	@Autowired
	MessageSender sender;
	
	@Test
	public void testSendandRecieve() {
		System.out.println("TEST send and RECIEVE");
	}
}
