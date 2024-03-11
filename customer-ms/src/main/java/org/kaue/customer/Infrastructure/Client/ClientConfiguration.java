package org.kaue.customer.Infrastructure.Client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("client.url")
@Configuration
@Getter
@Setter
public class ClientConfiguration {
    private String fraudURL;
}
