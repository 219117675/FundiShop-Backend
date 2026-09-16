package za.ac.cput.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

@Service
public class UserService extends BaseService<User> {

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return super.create(user);
    }
}