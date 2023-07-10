package com.citiustech.flightbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
	@SequenceGenerator(name = "flight_seq", sequenceName = "flight_sequence", initialValue = 201, allocationSize = 1)
	private int flightId;

//	flight_name – varchar(20) - unique
	@Column(name = "flight_name", unique = true, length = 20)
	private String flightName;
  
//	flight_date – date
	@Column(name = "flight_date")
	private Date flightDate;
  
//	flight_source – varchar(20)
	@Column(name = "flight_source", length = 20)
	private String flightSource;

//	flight_destination – varchar(20)
	@Column(name = "flight_destination", length = 20)
	private String flightDestination;
  
//	flight_price – float
	@Column(name = "flight_price")
	private double flightPrice;

//	flight_duration – float
	@Column(name = "flight_duration")
	private double flightDuration;

//	flight_capacity - int
	@Column(name = "flight_capacity")
	private int flightCapacity;

}
