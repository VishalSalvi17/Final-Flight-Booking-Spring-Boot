package com.citiustech.flightbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
	@SequenceGenerator(name = "booking_seq", sequenceName = "booking_sequence", initialValue = 301, allocationSize = 1)
	private int bookingId;

//	customer_id – int -foreign key
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
   
//	flight_id – int – foreign key
	@OneToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;

//	booking_amount – float
	@Column(name = "booking_amount")
	private double bookingAmount;

//	seat_number – int
	@Column(name = "seat_number")
	private int seatNumber;
}
