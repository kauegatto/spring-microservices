package org.kaue.customer.Domain.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kaue.customer.Domain.Clients.Fraud.IFraudClient;
import org.kaue.customer.Domain.Repository.ICustomerRepository;
import org.kaue.customer.Domain.Dto.CustomerRequest;
import org.kaue.customer.Domain.Model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService{
  private final ICustomerRepository repository;
  private final IFraudClient fraudClient;
  @Transactional
  public void registerCustomer(CustomerRequest customerRequest){
    var customer = Customer.builder()
            .email(customerRequest.email())
            .firstName(customerRequest.firstName())
            .lastName(customerRequest.lastName())
            .build();
    // todo validations
    Customer response = repository.save(customer);
    var fraudResponse = fraudClient.checkForFraud(response.getId());
    if(fraudResponse.isFraudster()){
      log.warn("User of email {} tried to commit a fraud. Creation will be rollbacked", response.getEmail());
      throw new RuntimeException("An error has occurred.");
    }
  }
}
