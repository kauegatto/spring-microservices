package org.kaue.customer.Domain.Repository;

import org.kaue.customer.Domain.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
