package org.kaue.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CustomerApplication {
  public static void main(String[] args) {
    System.out.println("Starting Customer Microservice!");
    SpringApplication.run(CustomerApplication.class, args);
  }
}