package dev.ardijorganxhi.shkruajshqip.model.dto;

import dev.ardijorganxhi.shkruajshqip.model.dto.base.BaseDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.VoteType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class VoteDto extends BaseDto {

    private VoteType vote;
    private String user;
    private String entry;
}
