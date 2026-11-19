package com.turfhub.turfhub_backend.repository;

import com.turfhub.turfhub_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

