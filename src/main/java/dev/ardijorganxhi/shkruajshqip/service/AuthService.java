package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.model.request.LoginRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.RegisterRequest;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Transactional
    public void register(RegisterRequest request) {
        final String encryptedPassword = passwordEncoder.encode(request.password());
        final User user = User.builder()
                .username(request.username())
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .password(encryptedPassword)
                .build();
        userRepository.save(user);
    }

    public String login(LoginRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        } catch (DisabledException e) {
            throw new Exception("Disabled");
        }

        final User user = userRepository.findByEmail(request.email()).orElseThrow();
        return tokenService.generateToken(user);


    }

}
