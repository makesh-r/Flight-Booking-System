package com.mk.ars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Flight> flights = new ArrayList<>();

    // ✅ Convenience method — keeps both sides in sync
    public void addFlight(Flight flight) {
        flights.add(flight);
        flight.setAirline(this);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
        flight.setAirline(null);
    }
}
