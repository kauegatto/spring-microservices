package org.fraud.Controller;

import lombok.extern.slf4j.Slf4j;
import org.fraud.Domain.Dto.FraudResponse;
import org.fraud.Domain.FraudChecker;
import org.fraud.Repository.FraudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fraudChecker")
@Slf4j
public record FraudController(FraudRepository fraudRepository) {
  @GetMapping("/{id}")
  ResponseEntity<FraudChecker> getById(@PathVariable Long id) {
    log.info("Start searching for fraud of id {}", id);
    Optional<FraudChecker> fraudChecker = fraudRepository.findById(id);
    return fraudChecker.map(fraud -> {
      log.info("Found fraud with id {}. Returning details.", fraud.getId()); // Assuming FraudChecker has an getId() method
      return ResponseEntity.ok(fraud);
    }).orElseGet(() -> {
      log.info("Fraud of id {} not found", id);
      return ResponseEntity.notFound().build();
    });
  }


  @GetMapping("/consumer/{id}/isFraudster")
  ResponseEntity<FraudResponse> isCustomerFraudster(@PathVariable int id) {
    var newFraud = FraudChecker.builder()
            .customerId(id)
            .createdAt(LocalDateTime.now())
            .isFraudster(false)
            .build();
    var response = fraudRepository.save(newFraud);
    log.info("mock fraud of id: {} created", response.getId());
    return fraudRepository.findById(response.getId()).map(found -> ResponseEntity.ok(new FraudResponse(found.getIsFraudster()))
    ).orElse(ResponseEntity.notFound().build());
  }
}
