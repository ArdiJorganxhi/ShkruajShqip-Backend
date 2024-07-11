package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.Followship;
import dev.ardijorganxhi.shkruajshqip.mapper.FollowshipMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.FollowshipDto;
import dev.ardijorganxhi.shkruajshqip.model.error.GenericErrorMessage;
import dev.ardijorganxhi.shkruajshqip.model.exception.NotFoundException;
import dev.ardijorganxhi.shkruajshqip.repository.FollowshipRepository;
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import dev.ardijorganxhi.shkruajshqip.utils.IdentityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowshipService extends BaseService<Followship, FollowshipDto, FollowshipRepository, FollowshipMapper> {

    public FollowshipService(FollowshipRepository repository, FollowshipMapper mapper) {
        super(repository, mapper);
    }

    public void follow(Integer followingId) {
        final Followship followship = Followship.builder()
                .follower(IdentityUtils.getUser())
                .following(followingId)
                .build();
        save(followship);
    }

    public void unfollow(Integer followingId) {
        final Followship followship = repository.findByFollowerAndFollowing(IdentityUtils.getUser(), followingId);
        followship.setActive(false);
        save(followship);
    }

    public List<FollowshipDto> getFollowersOfUser(Integer userId) {
        final List<Followship> followers = repository.findByFollower(userId)
                .orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("No followers found").build()));
        return followers.stream().map(mapper::convertEntityToDto).toList();
    }

    public List<FollowshipDto> getFollowingOfUser(Integer userId) {
        final List<Followship> following = repository.findByFollowing(userId)
                .orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("No following found").build()));
        return following.stream().map(mapper::convertEntityToDto).toList();
    }
}
