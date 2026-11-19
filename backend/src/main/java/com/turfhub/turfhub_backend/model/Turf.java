package com.turfhub.turfhub_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turf")
public class Turf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String sportType;
    private Double pricePerHour;

    //Constructors
    public Turf() {}

    public Turf(Long id, String name, String location, String sportType, Double pricePerHour) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.sportType = sportType;
        this.pricePerHour = pricePerHour;
    }

    //Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getSportType() { return sportType; }
    public Double getPricePerHour() { return pricePerHour; }

    //Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setSportType(String sportType) { this.sportType = sportType; }
    public void setPricePerHour(Double pricePerHour) { this.pricePerHour = pricePerHour; }
}

