package dev.ardijorganxhi.shkruajshqip.repository;

import dev.ardijorganxhi.shkruajshqip.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
