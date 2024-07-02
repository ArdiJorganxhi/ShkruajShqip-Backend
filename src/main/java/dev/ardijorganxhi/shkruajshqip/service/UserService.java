package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.mapper.UserMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findUserById(Integer id) {
        final User user = userRepository.findById(id).orElseThrow();
        return userMapper.convertEntityToDto(user);
    }
}
