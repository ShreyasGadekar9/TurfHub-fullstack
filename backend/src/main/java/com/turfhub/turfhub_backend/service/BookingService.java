package com.turfhub.turfhub_backend.service;

import com.turfhub.turfhub_backend.model.Booking;
import com.turfhub.turfhub_backend.model.Slot;
import com.turfhub.turfhub_backend.repository.BookingRepository;
import com.turfhub.turfhub_backend.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private SlotRepository slotRepository;

    public BookingService(BookingRepository bookingRepository, SlotRepository slotRepository) {
        this.bookingRepository = bookingRepository;
        this.slotRepository = slotRepository;
    }

    //Book a slot
    public Booking bookSlot(Long slotId, String userName) {
        Slot slot = slotRepository.findById(slotId).orElse(null);
        if (slot == null) {
            throw new RuntimeException("Slot not found");
        }
        if (slot.isBooked()) {
            throw new RuntimeException("Slot is already booked");
        }
        slot.setBooked(true);
        slotRepository.save(slot);

        Booking booking = new Booking();
        booking.setSlot(slot);
        booking.setUserName(userName);
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    //Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    //Get booking by id
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    //Cancel a booking
    public Booking cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            return null;
        }
        booking.setStatus("CANCELLED");
        booking.getSlot().setBooked(false);
        slotRepository.save(booking.getSlot());
        return bookingRepository.save(booking);
    }
}

