package com.citiustech.flightbooking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.flightbooking.model.BookingDetails;
import com.citiustech.flightbooking.model.Customer;
import com.citiustech.flightbooking.model.Flight;
import com.citiustech.flightbooking.repository.BookingDetailsRepository;

@RestController
@RequestMapping("api/bookingdetails")
public class BookingDetailsController {
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;

//	To get all booking details details
	@GetMapping
	public ResponseEntity<List<BookingDetails>> getAllBookingDetails(){
		List<BookingDetails> bookingDetails = bookingDetailsRepository.findAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cookie", "customer");
		headers.add("timestamp", LocalDateTime.now().toString());
		return new ResponseEntity<List<BookingDetails>>(bookingDetails, headers, HttpStatus.OK);
	}
	
//	To get booking details by id
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingDetails> getBookingDetailsById(@PathVariable int bookingId){
		BookingDetails bookingDetails = bookingDetailsRepository.findById(bookingId).get();
		return new ResponseEntity<BookingDetails>(bookingDetails , HttpStatus.OK);
	}
	
//	To add new booking details
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingDetails> addNewBookingDetails(@RequestBody BookingDetails bookingDetails){
		BookingDetails addBooking = bookingDetailsRepository.save(bookingDetails);
		return new ResponseEntity<BookingDetails>(addBooking,HttpStatus.CREATED);
	}
	
//	To update the existing booking details
	@PutMapping("/{bookingId}")
	public ResponseEntity<BookingDetails> updateBookingDetailsById(@RequestBody BookingDetails bookingDetails){
		BookingDetails updateBooking = bookingDetailsRepository.save(bookingDetails);
		return new ResponseEntity<BookingDetails>(updateBooking , HttpStatus.OK);
		
	}
	
//	To delete existing booking details
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<BookingDetails> deleteBookingDetailsById(@PathVariable int bookingId) {
		bookingDetailsRepository.deleteById(bookingId);
		return new ResponseEntity<BookingDetails>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
