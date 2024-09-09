package com.jsp.jst_ticket_booking_spring_boot.Traincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Train;
import com.jsp.jst_ticket_booking_spring_boot.service.TrainService;

@RestController
@RequestMapping(name="/train")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@PostMapping(value = "/saveTrain")
	public ResponseStructure<Train> saveTrainController(@RequestBody Train train) {
		return trainService.saveTrainService(train);
	}
	
	@GetMapping(value = "/searchTrainByNumber/{trainNumber}")
	public ResponseStructure<Train> searchTrainByNumberController(@PathVariable long trainNumber) {
		return trainService.searchTrainByNumberService(trainNumber);
	}
	
	@GetMapping(value = "/searchTrainBySourceAndDestination/{source}/{destination}")
	public ResponseStructure<List<Train>> searchTrainBySourceAndDestinationController(@PathVariable String source,@PathVariable String destination) {
		return trainService.searchTrainBySourceAndDestinationService(source, destination);
	}

}
