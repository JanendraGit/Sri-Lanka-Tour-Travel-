package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
