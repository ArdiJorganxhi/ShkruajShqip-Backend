package dev.ardijorganxhi.shkruajshqip.repository;

import dev.ardijorganxhi.shkruajshqip.entity.Vote;
import dev.ardijorganxhi.shkruajshqip.model.enums.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    Optional<List<Vote>> findByVoteAndEntryId(VoteType vote, Integer entryId);

}
