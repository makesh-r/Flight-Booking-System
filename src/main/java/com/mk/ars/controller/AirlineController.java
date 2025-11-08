package com.mk.ars.controller;

import com.mk.ars.entity.Airline;
import com.mk.ars.service.AirlineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService){
        this.airlineService = airlineService;
    }

    @PostMapping
    public ResponseEntity<String> createAirline(@RequestBody Airline airline){

        Long id = airlineService.createAirline(airline.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Airline>> getAllAirlines(){
        return ResponseEntity.status(HttpStatus.FOUND).body(airlineService.getAllAirlines());
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Long airlineId){
        Airline airline = airlineService.findAirline(airlineId);
        return ResponseEntity.status(HttpStatus.FOUND).body(airline);
    }
}
