package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.mapper.UserMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.request.UpdateRequest;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findUserById(Integer id) {
        final User user = userRepository.findById(id).orElseThrow();
        return userMapper.convertEntityToDto(user);
    }

    public void updateUserById(Integer id, UpdateRequest request) {
        final User user = userRepository.findById(id).orElseThrow();
        user.setName(Objects.equals(request.name(), "") ? request.name() : user.getName());
        user.setSurname(Objects.equals(request.surname(), "") ? request.surname() : user.getSurname());
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        final User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }
}
