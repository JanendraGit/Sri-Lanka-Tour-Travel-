package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
