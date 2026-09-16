package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.repository.FundiProfileRepository;

@Service
public class FundiProfileService extends BaseService<FundiProfile> {

    private final FundiProfileRepository repository;

    public FundiProfileService(FundiProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public FundiProfile getByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fundi profile not found for user id: " + userId
                        )
                );
    }
}