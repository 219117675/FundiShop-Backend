package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Storefront;

public interface StorefrontRepository extends JpaRepository<Storefront, Long> {
}
