package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import dev.ardijorganxhi.shkruajshqip.mapper.base.BaseMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<UserDto, User> {

    public UserDto convertEntityToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .createdBy(user.getCreatedBy())
                .createdOn(user.getCreatedDate())
                .lastModifiedOn(user.getLastModifiedDate())
                .lastModifiedBy(user.getLastModifiedBy())
                .build();
    }
}
