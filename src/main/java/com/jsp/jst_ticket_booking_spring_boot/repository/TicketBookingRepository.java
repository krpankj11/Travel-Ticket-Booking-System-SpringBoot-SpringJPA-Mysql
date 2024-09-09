package com.jsp.jst_ticket_booking_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer>{

}