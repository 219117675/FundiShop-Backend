package za.ac.cput.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.User;
import za.ac.cput.domain.enums.Role;
import za.ac.cput.domain.enums.TradeCategory;
import za.ac.cput.repository.FundiProfileRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.dto.RegistrationRequest;

import java.math.BigDecimal;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final FundiProfileRepository fundiProfileRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(
            UserRepository userRepository,
            FundiProfileRepository fundiProfileRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.fundiProfileRepository = fundiProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User register(RegistrationRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email address is already registered.");
        }

        Role role = Role.valueOf(request.getRole().toUpperCase());

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .emailVerified(false)
                .build();

        User savedUser = userRepository.save(user);

        if (role == Role.FUNDI) {

            if (request.getTradeCategory() == null ||
                    request.getTradeCategory().isBlank()) {

                throw new RuntimeException(
                        "Trade category is required for Fundi registration."
                );
            }

            FundiProfile fundiProfile = FundiProfile.builder()
                    .user(savedUser)
                    .tradeCategory(
                            TradeCategory.valueOf(
                                    request.getTradeCategory().toUpperCase()
                            )
                    )
                    .bio(request.getBio())
                    .calloutFee(
                            request.getCalloutFee() != null
                                    ? BigDecimal.valueOf(request.getCalloutFee())
                                    : null
                    )
                    .hourlyRate(
                            request.getHourlyRate() != null
                                    ? BigDecimal.valueOf(request.getHourlyRate())
                                    : null
                    )
                    .serviceAreaRadiusKm(
                            request.getServiceAreaRadiusKm()
                    )
                    .build();

            fundiProfileRepository.save(fundiProfile);
        }

        return savedUser;
    }
}