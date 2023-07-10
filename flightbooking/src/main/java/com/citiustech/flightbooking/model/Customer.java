package com.citiustech.flightbooking.model;

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
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", initialValue = 101, allocationSize = 1)
	private int customerId;
	
//	customer_name -varchar(20)
	@Column(name = "customer_name", length = 20)
	private String customerName;
	
//	customer_username -varchar(20) - unique
	@Column(name = "customer_username", unique = true, length = 20)
	private String customerUsername;
	
//	customer_password- varchar(20)
	@Column(name = "customer_password", length = 20)
	private String customerPassword;
	
//	customer_email- varchar(25)
	@Column(name = "customer_email", length = 25)
	private String customerEmail;
	
//	custom_phone -varchar(15)
	@Column(name = "customer_phone", length = 15)
	private String customerPhone;	
}
