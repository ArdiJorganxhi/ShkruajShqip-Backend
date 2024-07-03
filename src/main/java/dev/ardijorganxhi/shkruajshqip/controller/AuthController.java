package dev.ardijorganxhi.shkruajshqip.controller;

import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.request.LoginRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.RegisterRequest;
import dev.ardijorganxhi.shkruajshqip.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<GenericResponse<String>> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return GenericResponse.success(MessageResponse.REGISTRATION_IS_SUCCESSFUL, null);
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse<String>> login(@RequestBody LoginRequest request) throws Exception {
        final String token = authService.login(request);
        return GenericResponse.success(MessageResponse.LOGIN_IS_SUCCESSFUL, token);
    }
}
