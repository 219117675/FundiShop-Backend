package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dto.LoginRequest;
import za.ac.cput.dto.LoginResponse;
import za.ac.cput.service.LoginService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(loginService.login(request));
    }
}