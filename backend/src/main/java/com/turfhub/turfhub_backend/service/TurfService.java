package com.turfhub.turfhub_backend.service;

import com.turfhub.turfhub_backend.model.Turf;
import com.turfhub.turfhub_backend.repository.TurfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurfService {

    private TurfRepository turfRepository;
    public TurfService(TurfRepository turfRepository) {
        this.turfRepository = turfRepository;
    }

    //Get all turfs
    public List<Turf> getAllTurfs() {
        return turfRepository.findAll();
    }

    //Get turf by id
    public Turf getTurfById(Long id) {
        return turfRepository.findById(id).orElse(null);
    }

    //Add new turf
    public Turf addTurf(Turf turf) {
        return turfRepository.save(turf);
    }
}

