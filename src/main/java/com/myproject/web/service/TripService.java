package com.myproject.web.service;

import java.util.List;

import com.myproject.web.domain.TripVO;

public interface TripService {
	public List<TripVO> readTripList() throws Exception;
	public List<TripVO> readUserTripList(String userId) throws Exception;
	public TripVO readTrip(int id) throws Exception;
	public int addTrip(TripVO vo) throws Exception;
	public void updateTrip(TripVO vo) throws Exception;
	public void deleteTrip(int id) throws Exception;
	
	
}
