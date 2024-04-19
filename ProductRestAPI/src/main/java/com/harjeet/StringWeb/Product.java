package com.harjeet.StringWeb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	@Id
	private int id;
	@NotNull
	private String name;
	@Size(max = 100)
	private String description;
	@Min(1)
	private int price;
	
	@Id 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


}


/*
 * 
 * about messaging
 * p-t-p  ( one one)
 * msg is send and consumed , once it's consumed it got lost 
 * it also supports synchronous request/reply messaging
 * 
 * public subscribed , same msg can be recieved by multiple subscriber
 * - JMS provider ( communicate with multiple servers)
 * - JMS 2.0
 * 
 * Specification ( set of rules)
 *  API is for the developers 
 *  
*/