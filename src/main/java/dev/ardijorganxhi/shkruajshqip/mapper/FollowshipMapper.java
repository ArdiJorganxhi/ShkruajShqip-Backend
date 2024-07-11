package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.Followship;
import dev.ardijorganxhi.shkruajshqip.mapper.base.BaseMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.FollowshipDto;
import org.springframework.stereotype.Component;

@Component
public class FollowshipMapper implements BaseMapper<FollowshipDto, Followship> {


    public FollowshipDto convertEntityToDto(Followship entity) {
        return FollowshipDto.builder()
                .id(entity.getId())
                .followerId(entity.getFollower())
                .followerUsername(entity.getFollowerUser().getUsernameOfUser())
                .followingId(entity.getFollowing())
                .followingUsername(entity.getFollowingUser().getUsernameOfUser())
                .createdBy(entity.getCreatedBy())
                .createdOn(entity.getCreatedDate())
                .lastModifiedBy(entity.getLastModifiedBy())
                .lastModifiedOn(entity.getLastModifiedDate())
                .build();
    }
}
