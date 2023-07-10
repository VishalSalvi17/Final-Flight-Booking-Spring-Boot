package com.citiustech.flightbooking.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.flightbooking.model.Flight;
import com.citiustech.flightbooking.repository.FlightRepository;

@RestController
@RequestMapping("api/flight")
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;
	
//	To get all flights
	@GetMapping()
	public ResponseEntity<List<Flight>> getAllFlights(){
		List<Flight> flights = flightRepository.findAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cookie", "flight");
		headers.add("timestamp", LocalDateTime.now().toString());
		return new ResponseEntity<List<Flight>>(flights, headers, HttpStatus.OK);
	}
	
//	To get flight by id
	@GetMapping("/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable int flightId){
		Flight flight = flightRepository.findById(flightId).get();
		return new ResponseEntity<Flight>(flight , HttpStatus.OK);
	}
	
//	1. /flight/{source}/{destination}/{date} – this endpoint will fetch all flights with provided 
//	source to destination on provided date.
	public ResponseEntity<Flight> getFlightBySourceDesinationDate(@PathVariable String flightSource, @PathVariable String flightDestination, @PathVariable Date flightDate){
		Flight flight = (Flight) flightRepository.findAll();
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}


//	3. /flight/{flight} – this endpoint will insert new flight in table
//	To add new Flight
	@PostMapping()
	public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
		Flight addFlight = flightRepository.save(flight);
		return new ResponseEntity<Flight>(addFlight,HttpStatus.CREATED);
	}

	
//	To update existing flight
	@PutMapping("/{flightId}")
	public ResponseEntity<Flight> updateFlightById(@RequestBody Flight flight){
		Flight updateFlight = flightRepository.save(flight);
		return new ResponseEntity<Flight>(updateFlight , HttpStatus.OK);
	}
	
//	4. /flight/{flight_id}/{flight} – this end point will update flight details whose flight_id provided.
	@PutMapping("/{flightId}/{flight}")
	public ResponseEntity<Flight> updateFlightByIdAndFlight(@RequestBody Flight flight){
		Flight updateFlight = flightRepository.save(flight);
		return new ResponseEntity<Flight>(updateFlight , HttpStatus.OK);
	}
	
//	To delete existing flight
	@DeleteMapping("/{flightId}")
	public ResponseEntity<Flight> deleteFlightById(@PathVariable int flightId) {
		flightRepository.deleteById(flightId);
		return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
	}
	
	

}
