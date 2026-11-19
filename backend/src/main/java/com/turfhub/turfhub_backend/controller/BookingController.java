package com.turfhub.turfhub_backend.controller;

import com.turfhub.turfhub_backend.model.Booking;
import com.turfhub.turfhub_backend.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //Book a slot
    @PostMapping()
    public ResponseEntity<?> bookSlot(@RequestBody Map<String, Object> body) {
        try {
            Long slotId = Long.valueOf(body.get("slotId").toString());
            String userName = body.get("userName").toString();
            Booking booking = bookingService.bookSlot(slotId, userName);
            return ResponseEntity.status(201).body(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    //Get all bookings
    @GetMapping()
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookingList = bookingService.getAllBookings();
        if (bookingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(bookingList);
    }

    //Get booking by id
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking bookingResp = bookingService.getBookingById(id);
        if (bookingResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(bookingResp);
    }

    //Cancel a booking
    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        Booking bookingResp = bookingService.cancelBooking(id);
        if (bookingResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookingResp);
    }
}

