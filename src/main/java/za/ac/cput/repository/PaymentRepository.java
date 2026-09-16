package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
