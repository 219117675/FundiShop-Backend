package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
