package org.kaue.customer.WebAPI.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.kaue.customer.Domain.Dto.CustomerRequest;
import org.kaue.customer.Domain.Service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public record CustomerController (CustomerService service) {

  @PostMapping
  public void register(@RequestBody CustomerRequest customerRequest){
    log.info("Request to register a new customer: {}", customerRequest);
    service.registerCustomer(customerRequest);
  }

}
