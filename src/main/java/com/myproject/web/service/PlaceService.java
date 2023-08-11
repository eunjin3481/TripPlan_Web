package com.myproject.web.service;

import java.util.List;

import com.myproject.web.domain.PlaceVO;


public interface PlaceService {
	public PlaceVO readPlace(int id) throws Exception;
	public List<PlaceVO> readPlaceList(int id) throws Exception;
	public int addPlace(PlaceVO vo) throws Exception;
	public void updatePlace(PlaceVO vo) throws Exception;
	public void deletePlace(int id) throws Exception;
	
}
