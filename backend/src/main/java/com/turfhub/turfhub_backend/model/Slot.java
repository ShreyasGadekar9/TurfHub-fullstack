package com.turfhub.turfhub_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turf_id")
    private Turf turf;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean booked = false;

    //Constructors
    public Slot() {}

    public Slot(Long id, Turf turf, LocalDate date, LocalTime startTime, LocalTime endTime, boolean booked) {
        this.id = id;
        this.turf = turf;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.booked = booked;
    }

    //Getters
    public Long getId() { return id; }
    public Turf getTurf() { return turf; }
    public LocalDate getDate() { return date; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public boolean isBooked() { return booked; }

    //Setters
    public void setId(Long id) { this.id = id; }
    public void setTurf(Turf turf) { this.turf = turf; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setBooked(boolean booked) { this.booked = booked; }
}

