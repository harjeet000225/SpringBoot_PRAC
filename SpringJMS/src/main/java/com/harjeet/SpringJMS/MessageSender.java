package com.harjeet.SpringJMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmstemplate;
	
	@Value("${springjms.myQueue}")
	private String queue;
	
	//*
	public void send(String message) {
		System.out.println("Message Sender : " +message);
		MessageCreator mc= s-> s.createTextMessage("hello spring jms");
		jmstemplate.send(queue,mc);
	}

}
