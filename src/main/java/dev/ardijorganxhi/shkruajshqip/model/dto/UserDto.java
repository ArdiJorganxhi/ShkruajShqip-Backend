package dev.ardijorganxhi.shkruajshqip.model.dto;

import dev.ardijorganxhi.shkruajshqip.model.dto.base.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

    private String username;
    private String name;
    private String surname;
    private String email;



}
