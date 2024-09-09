package com.jsp.jst_ticket_booking_spring_boot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dao.TicketBookingDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;
import com.jsp.jst_ticket_booking_spring_boot.service.TicketBookingService;

import jakarta.servlet.http.HttpSession;

@Service
public class TicketBookingServiceImpl implements TicketBookingService{

	@Autowired
	private TicketBookingDao bookingDao;
	
	@Autowired
	private ResponseStructure<TicketBooking> responseStructure;
	
	//@Autowired
	//private HttpSession httpSession;
	
	@Override
	public ResponseStructure<TicketBooking> saveTicketBookingService(TicketBooking booking) {
		TicketBooking ticketBooking=bookingDao.saveTicketBookingDao(booking);
		//httpSession.getAttribute(null)
		
		if(ticketBooking!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Ticket Booked");
			responseStructure.setData(booking);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Ticket Not Booked");
			responseStructure.setData(null);
			return responseStructure;
		}
	}

}
