package org.fraud.Repository;

import org.fraud.Domain.FraudChecker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudChecker, Long> {
}
