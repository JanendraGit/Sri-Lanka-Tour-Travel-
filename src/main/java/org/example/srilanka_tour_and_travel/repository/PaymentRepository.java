package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
