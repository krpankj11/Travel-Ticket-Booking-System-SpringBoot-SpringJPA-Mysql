package com.jsp.jst_ticket_booking_spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.jst_ticket_booking_spring_boot.dto.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{
	
	//@Query(value = "select * from train where source=?1 and destination=?2" , nativeQuery = true)
	public List<Train> findBySourceAndDestination(String source, String destination);

}
