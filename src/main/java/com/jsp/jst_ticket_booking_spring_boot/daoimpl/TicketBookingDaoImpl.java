package com.jsp.jst_ticket_booking_spring_boot.daoimpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.jst_ticket_booking_spring_boot.dao.TicketBookingDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;
import com.jsp.jst_ticket_booking_spring_boot.repository.TicketBookingRepository;

@Repository
public class TicketBookingDaoImpl implements TicketBookingDao{

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Override
	public TicketBooking saveTicketBookingDao(TicketBooking booking) {
		Random random=new Random();
		long pnr=1000000000 + random.nextLong(900000000);
		
		booking.setPnr(pnr);
		
		ticketBookingRepository.save(booking);
		
		return booking;
	}

}
