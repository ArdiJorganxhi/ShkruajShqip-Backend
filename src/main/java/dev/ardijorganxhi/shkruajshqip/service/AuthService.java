package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.model.request.RegisterRequest;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public void register(RegisterRequest request) {
        final User user = User.builder()
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .password(request.password())
                .build();
        userRepository.save(user);
    }
}
