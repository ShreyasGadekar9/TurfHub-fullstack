package com.turfhub.turfhub_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    private String userName;
    private String status;

    //Constructors
    public Booking() {}

    public Booking(Long id, Slot slot, String userName, String status) {
        this.id = id;
        this.slot = slot;
        this.userName = userName;
        this.status = status;
    }

    //Getters
    public Long getId() { return id; }
    public Slot getSlot() { return slot; }
    public String getUserName() { return userName; }
    public String getStatus() { return status; }

    //Setters
    public void setId(Long id) { this.id = id; }
    public void setSlot(Slot slot) { this.slot = slot; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setStatus(String status) { this.status = status; }
}

