package org.kaue.customer.Domain.Dto;

public record CustomerRequest(
  String firstName,
  String lastName,
  String email
) { }
