package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.mapper.UserMapper;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.UserUpdateRequest;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import dev.ardijorganxhi.shkruajshqip.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public PagingResult<UserDto> findAllUsers(PaginationRequest request) {
        final Pageable pageable = PaginationUtils.getPageable(request.getPage(), request.getSize(), request.getDirection(), request.getSortField());
        final Page<User> users = userRepository.findAll(pageable);
        final List<UserDto> userDtos = users.stream().map(userMapper::convertEntityToDto).toList();
        return new PagingResult<>(
                userDtos,
                users.getTotalPages(),
                users.getTotalElements(),
                users.getSize(),
                users.getNumber(),
                users.isEmpty()
        );
    }

    public UserDto findUserById(Integer id) {
        final User user = userRepository.findById(id).orElseThrow();
        return userMapper.convertEntityToDto(user);
    }

    public void updateUserById(Integer id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(Objects.equals(request.name(), "") ? request.name() : user.getName());
        user.setSurname(Objects.equals(request.surname(), "") ? request.surname() : user.getSurname());
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }
}
