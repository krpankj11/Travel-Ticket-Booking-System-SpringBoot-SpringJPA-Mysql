package com.jsp.jst_ticket_booking_spring_boot.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.jst_ticket_booking_spring_boot.dao.TrainDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.Train;
import com.jsp.jst_ticket_booking_spring_boot.repository.TrainRepository;

@Repository
public class TrainDaoImpl implements TrainDao{

	@Autowired
	private TrainRepository trainRepository;
	
	@Override
	public Train saveTrainDao(Train train) {
		return trainRepository.save(train);
	}

	@Override
	public Train searchTrainByNumberDao(long trainNumber) {
		return trainRepository.findById(trainNumber).orElse(null);
	}

	@Override
	public List<Train> searchTrainBySourceAndDestinationDao(String source, String destination) {
		return trainRepository.findBySourceAndDestination(source, destination);
	}

}
