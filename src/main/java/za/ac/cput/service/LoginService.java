package za.ac.cput.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginRequest;
import za.ac.cput.dto.LoginResponse;
import za.ac.cput.repository.UserRepository;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository,
                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {

        System.out.println("=================================");
        System.out.println("LOGIN EMAIL: " + request.getEmail());
        System.out.println("LOGIN PASSWORD: " + request.getPassword());

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            System.out.println("RESULT: USER NOT FOUND");
            throw new RuntimeException("User not found");
        }

        System.out.println("USER FOUND:");
        System.out.println("ID: " + user.getId());
        System.out.println("NAME: " + user.getFullName());
        System.out.println("EMAIL: " + user.getEmail());
        System.out.println("ROLE: " + user.getRole());
        System.out.println("HASHED PASSWORD: " + user.getPassword());

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        System.out.println("PASSWORD MATCHES: " + passwordMatches);
        System.out.println("=================================");

        if (!passwordMatches) {
            throw new RuntimeException("Password does not match");
        }

        return LoginResponse.builder()
                .success(true)
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole().name())
                .message("Login successful")
                .build();
    }
}