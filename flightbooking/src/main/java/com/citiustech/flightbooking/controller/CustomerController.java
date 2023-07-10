package com.citiustech.flightbooking.controller;

import java.time.LocalDateTime;
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

import com.citiustech.flightbooking.model.Customer;
import com.citiustech.flightbooking.repository.CustomerRepository;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
//	To get all customer details
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerRepository.findAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cookie", "customer");
		headers.add("timestamp", LocalDateTime.now().toString());
		return new ResponseEntity<List<Customer>>(customers, headers, HttpStatus.OK);
	}
	
//	To get customer by Id
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
		Customer customer = customerRepository.findById(customerId).get();
		return new ResponseEntity<Customer>(customer , HttpStatus.OK);
	}
	
//	To add new customer details
	@PostMapping()
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer){
		Customer addCustomer = customerRepository.save(customer);
		return new ResponseEntity<Customer>(addCustomer,HttpStatus.CREATED);
	}
	
//	To update the existing customer details
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer){
		Customer updateCustomer = customerRepository.save(customer);
		return new ResponseEntity<Customer>(updateCustomer , HttpStatus.OK);
		
	}
	
//	To delete existing customer
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int customerId) {
		customerRepository.deleteById(customerId);
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}
	
	
}
