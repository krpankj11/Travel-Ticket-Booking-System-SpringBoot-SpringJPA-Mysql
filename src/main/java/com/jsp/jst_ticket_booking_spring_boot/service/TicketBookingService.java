package com.jsp.jst_ticket_booking_spring_boot.service;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;

public interface TicketBookingService {

	ResponseStructure<TicketBooking> saveTicketBookingService(TicketBooking booking);
	
}
