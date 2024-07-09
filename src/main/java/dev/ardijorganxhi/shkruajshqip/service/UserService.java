package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.mapper.UserMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.error.GenericErrorMessage;
import dev.ardijorganxhi.shkruajshqip.model.exception.NotFoundException;
import dev.ardijorganxhi.shkruajshqip.model.request.UserUpdateRequest;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService extends BaseService<User, UserDto, UserRepository, UserMapper> {

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }
    public void updateUserById(Integer id, UserUpdateRequest request) {
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("User not found").build()));
        user.setName(Objects.equals(request.name(), "") ? request.name() : user.getName());
        user.setSurname(Objects.equals(request.surname(), "") ? request.surname() : user.getSurname());
        save(user);
    }
}
