package com.satyam.jobtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// One annotation that bundles three: @Configuration, @EnableAutoConfiguration, @ComponentScan.
@SpringBootApplication
public class JobTrackerApplication {

    public static void main(String[] args) {
        // Starts Spring: builds the application context, starts embedded Tomcat on :8080.
        SpringApplication.run(JobTrackerApplication.class, args);
    }
}
