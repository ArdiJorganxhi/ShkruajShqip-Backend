package dev.ardijorganxhi.shkruajshqip.repository;

import dev.ardijorganxhi.shkruajshqip.entity.Followship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowshipRepository extends JpaRepository<Followship, Integer> {

    Followship findByFollowerAndFollowing(Integer follower, Integer following);
    Optional<List<Followship>> findByFollower(Integer follower);
    Optional<List<Followship>> findByFollowing(Integer following);
}
