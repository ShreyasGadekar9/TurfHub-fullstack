package com.turfhub.turfhub_backend.controller;

import com.turfhub.turfhub_backend.model.Turf;
import com.turfhub.turfhub_backend.service.TurfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turfs")
public class TurfController {

    private TurfService turfService;
    public TurfController(TurfService turfService) {
        this.turfService = turfService;
    }

    //Get all turfs
    @GetMapping()
    public ResponseEntity<List<Turf>> getAllTurfs() {
        List<Turf> turfList = turfService.getAllTurfs();
        if (turfList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(turfList);
    }

    //Get turf by id
    @GetMapping("/{id}")
    public ResponseEntity<Turf> getTurfById(@PathVariable Long id) {
        Turf turfResp = turfService.getTurfById(id);
        if (turfResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(turfResp);
    }

    //Add new turf
    @PostMapping()
    public ResponseEntity<Turf> addTurf(@RequestBody Turf turf) {
        Turf createdTurf = turfService.addTurf(turf);
        return ResponseEntity.status(201).body(createdTurf);
    }
}

