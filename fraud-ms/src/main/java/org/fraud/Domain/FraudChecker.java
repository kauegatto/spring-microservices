package org.fraud.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "FraudChecks")
public class FraudChecker {
  @Id
  @SequenceGenerator(
          name = "fraud_id_sequence",
          sequenceName = "fraud_id_sequence"
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "fraud_id_sequence"
  )
  private Long id;
  private int customerId;
  private Boolean isFraudster;
  private LocalDateTime createdAt;
}
