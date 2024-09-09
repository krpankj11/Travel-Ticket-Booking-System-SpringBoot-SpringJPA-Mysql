package com.jsp.jst_ticket_booking_spring_boot.TicketBookingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;
import com.jsp.jst_ticket_booking_spring_boot.service.TicketBookingService;

@RestController
@RequestMapping(value = "/ticketbooking")
public class TicketBookingController {
	
	@Autowired
	private TicketBookingService service;
	
	@PostMapping(value = "/saveTicketBookingService")
	public ResponseStructure<TicketBooking> saveTicketBookingService(@RequestBody TicketBooking booking) {
		return service.saveTicketBookingService(booking);
	}

}
