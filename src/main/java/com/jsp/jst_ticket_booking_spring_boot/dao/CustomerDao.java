package com.jsp.jst_ticket_booking_spring_boot.dao;

import org.springframework.stereotype.Repository;

import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;

@Repository
public interface CustomerDao {
	
	Customer saveCustomerDao(Customer customer);
	
	Customer findCustomerByEmailDao(String email);

}
