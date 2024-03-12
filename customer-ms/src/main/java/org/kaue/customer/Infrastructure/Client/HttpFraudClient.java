package org.kaue.customer.Infrastructure.Client;

import lombok.RequiredArgsConstructor;
import org.kaue.customer.Domain.Clients.Fraud.FraudResponseVo;
import org.kaue.customer.Domain.Clients.Fraud.IFraudClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class HttpFraudClient implements IFraudClient {
    private final RestTemplate restTemplate;
    private final ClientConfiguration clientConfiguration;
    @Override
    public FraudResponseVo checkForFraud(int customerId) {
        String url = clientConfiguration.getFraudURL() + "/api/v1/fraudChecker/consumer/{customerId}/isFraudster";
        return restTemplate.getForObject(url, FraudResponseVo.class, customerId);
    }
}