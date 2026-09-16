package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerId(Long customerId);

    List<Booking> findByFundiProfileIdOrderByCreatedAtDesc(
            Long fundiProfileId
    );

    List<Booking> findByCustomerIdOrderByCreatedAtDesc(
            Long customerId
    );



}