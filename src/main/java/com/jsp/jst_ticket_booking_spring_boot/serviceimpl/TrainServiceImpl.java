package com.jsp.jst_ticket_booking_spring_boot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dao.TrainDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.Train;
import com.jsp.jst_ticket_booking_spring_boot.service.TrainService;

import jakarta.servlet.http.HttpSession;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainDao trainDao;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private ResponseStructure<Train> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Train>> responseStructure2;

	@Override
	public ResponseStructure<Train> saveTrainService(Train train) {
		if(httpSession.getAttribute("adminSession") !=null) {
			Train train1=trainDao.saveTrainDao(train);
			if(train1!=null) {
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("Train Register");
				responseStructure.setData(train1);
				return responseStructure;
			}else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMessage("Train Not Register!!! Something Went Wrong");
				responseStructure.setData(train1);
				return responseStructure;
			}
		}else {
			responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
			responseStructure.setMessage("You are Not AUTHORIZED");
			responseStructure.setData(null);
			return responseStructure;
		}
	}

	@Override
	public ResponseStructure<Train> searchTrainByNumberService(long trainNumber) {
			Train train=trainDao.searchTrainByNumberDao(trainNumber);
			if(train!=null) {
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("Train Found");
				responseStructure.setData(train);
				return responseStructure;
			}else {
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("Train Not Found");
				responseStructure.setData(null);
				return responseStructure;
			}
		
	}

	@Override
	public ResponseStructure<List<Train>> searchTrainBySourceAndDestinationService(String source, String destination) {
			List<Train> list=trainDao.searchTrainBySourceAndDestinationDao(source, destination);
			if(!list.isEmpty()) {
				responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure2.setMessage("Train Found");
				responseStructure2.setData(list);
				return responseStructure2;
			}else {
				responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure2.setMessage("Train Not Found");
				responseStructure2.setData(list);
				return responseStructure2;
			}
			
		
	}

}
