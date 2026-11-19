package com.turfhub.turfhub_backend.service;

import com.turfhub.turfhub_backend.model.Slot;
import com.turfhub.turfhub_backend.model.Turf;
import com.turfhub.turfhub_backend.repository.SlotRepository;
import com.turfhub.turfhub_backend.repository.TurfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    private SlotRepository slotRepository;
    private TurfRepository turfRepository;

    public SlotService(SlotRepository slotRepository, TurfRepository turfRepository) {
        this.slotRepository = slotRepository;
        this.turfRepository = turfRepository;
    }

    //Get all slots for a turf
    public List<Slot> getSlotsByTurf(Long turfId) {
        return slotRepository.findByTurfId(turfId);
    }

    //Get only available (unbooked) slots for a turf
    public List<Slot> getAvailableSlots(Long turfId) {
        return slotRepository.findByTurfIdAndBooked(turfId, false);
    }

    //Add a slot to a turf
    public Slot addSlot(Long turfId, Slot slot) {
        Turf turf = turfRepository.findById(turfId).orElse(null);
        if (turf == null) {
            return null;
        }
        slot.setTurf(turf);
        return slotRepository.save(slot);
    }
}

