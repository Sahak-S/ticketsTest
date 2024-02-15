package com.example.ticketstest.controller;

import com.example.ticketstest.entity.Flight;
import com.example.ticketstest.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/min-flight-time")
    public ResponseEntity<Map<String, Integer>> getMinFlightTime() {
        List<Flight> flights = flightService.getAllFlights();
        Map<String, Integer> minFlightTimes = flightService.calculateMinFlightTime(flights);
        System.out.println(minFlightTimes);
        return ResponseEntity.ok(minFlightTimes);

    }

    // Other endpoints for average price, median, etc.
}
