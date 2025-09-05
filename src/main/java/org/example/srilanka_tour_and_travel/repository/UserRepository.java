package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
