package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.FundiProfile;

import java.util.Optional;

public interface FundiProfileRepository extends JpaRepository<FundiProfile, Long> {

    Optional<FundiProfile> findByUserId(Long userId);
}
