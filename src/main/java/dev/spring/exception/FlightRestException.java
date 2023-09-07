package dev.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class FlightRestException {

    @ExceptionHandler
    public ResponseEntity<FlightErrorResponse> handleFlightErrorException(FlightNotFoundException e) {
        FlightErrorResponse response = new FlightErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatusCode(HttpStatus.NOT_FOUND.toString());
        response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MMM/uuuu hh:mm:ss")));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
