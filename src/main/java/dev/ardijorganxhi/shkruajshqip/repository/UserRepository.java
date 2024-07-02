package dev.ardijorganxhi.shkruajshqip.repository;

import dev.ardijorganxhi.shkruajshqip.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
