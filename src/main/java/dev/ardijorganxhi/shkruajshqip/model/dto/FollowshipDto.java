package dev.ardijorganxhi.shkruajshqip.model.dto;

import dev.ardijorganxhi.shkruajshqip.model.dto.base.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FollowshipDto extends BaseDto {

    private Integer followerId;
    private String followerUsername;
    private Integer followingId;
    private String followingUsername;
}
