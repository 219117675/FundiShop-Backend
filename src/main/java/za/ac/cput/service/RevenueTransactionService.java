package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.RevenueTransaction;
import za.ac.cput.repository.RevenueTransactionRepository;

@Service
public class RevenueTransactionService extends BaseService<RevenueTransaction> {

    public RevenueTransactionService(RevenueTransactionRepository repository) {
        super(repository);
    }
}
