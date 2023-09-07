package dev.spring.impl;


import dev.spring.entity.Flight;
import dev.spring.repository.FlightRepository;
import dev.spring.response.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FlightServiceImpl {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightResponse findFlightsByCriteria(String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime arrivalDatetime) {
        Optional<Flight> flightByCriteria = flightRepository.findFlightByCriteria(departureAirport, arrivalAirport, departureDatetime, arrivalDatetime);
        
    }
}
