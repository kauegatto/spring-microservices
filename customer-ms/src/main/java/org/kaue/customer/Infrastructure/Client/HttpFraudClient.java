package org.kaue.customer.Infrastructure.Client;

import org.kaue.customer.Domain.Clients.Fraud.FraudResponseVo;
import org.kaue.customer.Domain.Clients.Fraud.IFraudClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class HttpFraudClient implements IFraudClient {
    private final RestClient restClient; // new in Spring boot 3.2
    public HttpFraudClient(ClientConfiguration clientConfiguration) {
        this.restClient = RestClient.create(clientConfiguration.getFraudURL());
    }
    @Override
    public FraudResponseVo checkForFraud(int customerId) {
        return restClient.get()
                .uri("/api/v1/fraudChecker/consumer/{customerId}/isFraudster", customerId)
                .retrieve()
                .body(FraudResponseVo.class);
    }
}
