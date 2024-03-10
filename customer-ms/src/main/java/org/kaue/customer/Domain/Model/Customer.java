package org.kaue.customer.Domain.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
  private long id;
  private String firstName;
  private String lastName;
  private String email;
}
