package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

@Service
public class ReviewService extends BaseService<Review> {

    public ReviewService(ReviewRepository repository) {
        super(repository);
    }
}
