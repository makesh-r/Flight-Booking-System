package com.mk.ars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

//    @ManyToMany(mappedBy = "passengers")
//    private List<Journey> journeys = new ArrayList<>();

    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    private List<Seat> bookedSeats = new ArrayList<>();
}
