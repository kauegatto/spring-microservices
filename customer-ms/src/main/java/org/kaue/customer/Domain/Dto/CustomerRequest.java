package org.kaue.customer.Domain.Dto;

import lombok.ToString;

@ToString
public record CustomerRequest(
  String firstName,
  String lastName,
  String email
) { }
