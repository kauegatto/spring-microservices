package org.kaue.customer.Domain.Clients.Fraud;

public interface IFraudClient {
    FraudResponseVo checkForFraud(int customerId);
}
