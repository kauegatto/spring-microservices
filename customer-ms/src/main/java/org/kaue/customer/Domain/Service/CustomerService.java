package org.kaue.customer.Domain.Service;

import org.kaue.customer.Domain.CustomerRepository.ICustomerRepository;
import org.kaue.customer.Domain.Dto.CustomerRequest;
import org.kaue.customer.Domain.Model.Customer;
import org.springframework.stereotype.Service;


@Service
public record CustomerService (ICustomerRepository repository){
  public void registerCustomer(CustomerRequest customerRequest){
    var customer = Customer.builder()
            .email(customerRequest.email())
            .firstName(customerRequest.firstName())
            .lastName(customerRequest.lastName())
            .build();
    // todo validations
    repository.register(customer);

  }
}
