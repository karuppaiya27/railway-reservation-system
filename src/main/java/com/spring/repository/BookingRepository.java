package com.spring.repository;

import com.spring.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserEmail(String email); // ✅ required for getBookingsByUsername
}
