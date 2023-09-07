package dev.spring.repository;

import dev.spring.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(value = "select f from Flight as f " +
            "where f.departureAirport=:departureAirport " +
            "and f.arrivalAirport=:arrivalAirport " +
            "and f.arrivalDatetime=:arrivalDatetime " +
            "and f.departureDatetime=:departureDatetime")
    Optional<Flight> findFlightByCriteria(@Param(value = "departureAirport") String departureAirport,
                                          @Param(value = "arrivalAirport") String arrivalAirport,
                                          @Param(value = "departureDatetime") LocalDateTime departureDatetime,
                                          @Param(value = "arrivalDatetime") LocalDateTime arrivalDatetime);

}
