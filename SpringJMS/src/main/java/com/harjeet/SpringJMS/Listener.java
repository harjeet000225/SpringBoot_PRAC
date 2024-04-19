package com.harjeet.SpringJMS;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Listener {

	@JmsListener(destination="${springjms.myQueue}")
	public void StringMsg(String message) {
		System.out.println("message recieved : " + message);
		
	}
}
