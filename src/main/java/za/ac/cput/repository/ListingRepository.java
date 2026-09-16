package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
