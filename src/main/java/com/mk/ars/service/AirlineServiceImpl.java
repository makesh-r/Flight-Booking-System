package com.mk.ars.service;

import com.mk.ars.entity.Airline;
import com.mk.ars.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService{

    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Long createAirline(String name) {
        Airline airline = new Airline();
        airline.setName(name);
        Airline savedAirline = airlineRepository.save(airline);
        return savedAirline.getId();
    }

    @Override
    public Airline findAirline(Long id) {
       Airline airline = airlineRepository.findById(id).orElse(null);
       return airline;
    }

    @Override
    public List<Airline> getAllAirlines() {
        List<Airline> airlines = airlineRepository.findAll();
        return airlines;
    }
}
