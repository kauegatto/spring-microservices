package org.kaue.customer.Domain.CustomerRepository;

import org.kaue.customer.Domain.Model.Customer;

public interface ICustomerRepository {
  void register(Customer customer);
}
