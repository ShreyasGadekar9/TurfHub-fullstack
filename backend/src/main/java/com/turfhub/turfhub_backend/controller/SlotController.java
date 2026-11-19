package com.turfhub.turfhub_backend.controller;

import com.turfhub.turfhub_backend.model.Slot;
import com.turfhub.turfhub_backend.service.SlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turfs/{turfId}/slots")
public class SlotController {

    private SlotService slotService;
    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    //Get all slots for a turf
    @GetMapping()
    public ResponseEntity<List<Slot>> getSlotsByTurf(@PathVariable Long turfId) {
        List<Slot> slotList = slotService.getSlotsByTurf(turfId);
        if (slotList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(slotList);
    }

    //Get available slots for a turf
    @GetMapping("/available")
    public ResponseEntity<List<Slot>> getAvailableSlots(@PathVariable Long turfId) {
        List<Slot> slotList = slotService.getAvailableSlots(turfId);
        if (slotList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(slotList);
    }

    //Add a slot to a turf
    @PostMapping()
    public ResponseEntity<Slot> addSlot(@PathVariable Long turfId, @RequestBody Slot slot) {
        Slot createdSlot = slotService.addSlot(turfId, slot);
        if (createdSlot == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body(createdSlot);
    }
}

