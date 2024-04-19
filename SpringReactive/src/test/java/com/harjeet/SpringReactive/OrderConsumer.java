package com.harjeet.SpringReactive;

import java.util.function.Consumer;

public class OrderConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println("check metod2");
		
	}

}
