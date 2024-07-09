package dev.ardijorganxhi.shkruajshqip.repository;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {

    Optional<List<Entry>> findByTopicId(Integer topicId);
    Optional<List<Entry>> findByUserId(Integer userId);
}
