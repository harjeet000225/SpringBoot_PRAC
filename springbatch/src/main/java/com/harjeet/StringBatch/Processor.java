package com.harjeet.StringBatch;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String>{

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside process");
		return "PROCESSED :" + item.toUpperCase();
	}

}
