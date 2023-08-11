package com.myproject.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.web.service.TripService;
import com.myproject.web.domain.TripVO;
import com.myproject.web.persistence.TripDAO;

@Service
public class TripServiceImpl implements TripService {
	@Autowired
	private TripDAO tripDAO;
	
	public List<TripVO> readTripList() throws Exception{
		return tripDAO.readList();
	}
	
	public List<TripVO> readUserTripList(String userId) throws Exception{
		return tripDAO.readUserList(userId);
	}
	
	public TripVO readTrip(int id) throws Exception {
		return tripDAO.read(id);
	}
	
	public int addTrip(TripVO student) throws Exception {
		return tripDAO.add(student);
	}
	
	public void updateTrip(TripVO student) throws Exception {
		tripDAO.update(student);
	}
	
	public void deleteTrip(int id) throws Exception {
		tripDAO.delete(id);
	}
}

