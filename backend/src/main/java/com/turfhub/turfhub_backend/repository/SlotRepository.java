package com.turfhub.turfhub_backend.repository;

import com.turfhub.turfhub_backend.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    List<Slot> findByTurfId(Long turfId);

    List<Slot> findByTurfIdAndBooked(Long turfId, boolean booked);
}

