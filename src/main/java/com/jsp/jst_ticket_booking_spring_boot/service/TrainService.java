package com.jsp.jst_ticket_booking_spring_boot.service;

import java.util.List;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Train;

public interface TrainService {
	
	ResponseStructure<Train> saveTrainService(Train train);
	
	ResponseStructure<Train> searchTrainByNumberService(long trainNumber);
	
	ResponseStructure<List<Train>> searchTrainBySourceAndDestinationService(String source, String destination);

}
