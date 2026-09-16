package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
