package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.mapper.UserMapper;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.UserUpdateRequest;
import dev.ardijorganxhi.shkruajshqip.repository.UserRepository;
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import dev.ardijorganxhi.shkruajshqip.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService extends BaseService<User, UserDto, UserRepository, UserMapper> {

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }
    public void updateUserById(Integer id, UserUpdateRequest request) {
        User user = repository.findById(id).orElseThrow();
        user.setName(Objects.equals(request.name(), "") ? request.name() : user.getName());
        user.setSurname(Objects.equals(request.surname(), "") ? request.surname() : user.getSurname());
        repository.save(user);
    }
}
