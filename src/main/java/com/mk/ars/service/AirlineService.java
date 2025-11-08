package com.mk.ars.service;

import com.mk.ars.entity.Airline;

import java.util.List;

public interface AirlineService {

    Long createAirline(String name);

    Airline findAirline(Long id);

    List<Airline> getAllAirlines();
}
