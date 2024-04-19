package com.harjeet.demo;

public class Customer {
	    private int id;
	    private String name;
	    //has-a
	    private Address address;

	    @Override
	    public String toString() {
	        return "Customer{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", address=" + address +
	                '}';
	    }

	    public Customer() {
	    }

	    public Customer(int id, String name, Address address) {
	        this.id = id;
	        this.name = name;
	        this.address = address;
	    }

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

	    public Address getAddress() {
	        return address;
	    }

	    public void setAddress(Address address) {
	        this.address = address;
	    }
}
