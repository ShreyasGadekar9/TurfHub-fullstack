package com.turfhub.turfhub_backend.repository;

import com.turfhub.turfhub_backend.model.Turf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurfRepository extends JpaRepository<Turf, Long> {
}

