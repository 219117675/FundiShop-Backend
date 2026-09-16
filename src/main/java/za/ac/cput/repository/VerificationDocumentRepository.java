package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.VerificationDocument;

public interface VerificationDocumentRepository extends JpaRepository<VerificationDocument, Long> {
}
