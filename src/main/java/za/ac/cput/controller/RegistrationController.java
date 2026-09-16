package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.dto.RegistrationRequest;
import za.ac.cput.service.RegistrationService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(
            RegistrationService registrationService) {

        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody RegistrationRequest request) {

        return ResponseEntity.ok(
                registrationService.register(request)
        );
    }
}