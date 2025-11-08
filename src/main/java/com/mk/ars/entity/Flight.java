package com.mk.ars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<Journey> journeys = new ArrayList<>();

    private Integer totalSeats;
    private Integer economySeats;
    private Integer businessSeats;
    private Integer firstClassSeats;

    public void addJourney(Journey journey){
        journeys.add(journey);
        journey.setFlight(this);
    }

    public void removeJourney(Journey journey){
        journeys.remove(journey);
        journey.setFlight(null);
    }

}
