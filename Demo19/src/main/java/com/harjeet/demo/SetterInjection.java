package com.harjeet.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //Get the customer Bean
        Customer customer = context.getBean(Customer.class);
        //Get all Customer information
        System.out.println("Id" + customer.getId());
        System.out.println("Name " + customer.getName());
        System.out.println("Address " + customer.getAddress().getCity() + " " + customer.getAddress().getState());

        customer.setId(1);
        customer.setName("Subramanian Murugan");
        Address address = customer.getAddress();
        address.setCity("Coimbatore");
        address.setState("Tamil nadu");
        customer.setAddress(address);

        System.out.println("Id" + customer.getId());
        System.out.println("Name " + customer.getName());
        System.out.println("Address " + customer.getAddress().getCity() + " " + customer.getAddress().getState());

    }
}
