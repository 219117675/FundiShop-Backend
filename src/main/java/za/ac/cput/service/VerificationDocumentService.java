package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.VerificationDocument;
import za.ac.cput.repository.VerificationDocumentRepository;

@Service
public class VerificationDocumentService extends BaseService<VerificationDocument> {

    public VerificationDocumentService(VerificationDocumentRepository repository) {
        super(repository);
    }
}
