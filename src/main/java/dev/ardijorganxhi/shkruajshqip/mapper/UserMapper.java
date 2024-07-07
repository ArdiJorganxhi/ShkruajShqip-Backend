package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto convertEntityToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsernameOfUser(),
                user.getName(),
                user.getSurname(),
                user.getEmail()
        );
    }
}
