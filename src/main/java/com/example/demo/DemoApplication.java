package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private CustomerRepository customerRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List allCustomers = this.customerRepository.findAll();
        System.out.println("Number of customers: " + allCustomers.size());

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        System.out.println("Saving new customer...");
        this.customerRepository.save(newCustomer);

        allCustomers = this.customerRepository.findAll();
        System.out.println("Number of customers: " + allCustomers.size());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,
                args
        );
    }
}
