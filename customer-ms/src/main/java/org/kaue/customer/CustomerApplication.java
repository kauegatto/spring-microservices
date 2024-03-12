package org.kaue.customer;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class CustomerApplication {
  public static void main(String[] args) {
    System.out.println("Starting Customer Microservice!");
    SpringApplication.run(CustomerApplication.class, args);
  }
}