package com.myproject.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.web.domain.PlaceVO;
import com.myproject.web.persistence.PlaceDAO;

@Service
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	private PlaceDAO placeDAO;
	
	public PlaceVO readPlace(int id) throws Exception{
		return placeDAO.read(id);
	}
	
	public List<PlaceVO> readPlaceList(int id) throws Exception{
		return placeDAO.readList(id);
	}
	
	public int addPlace(PlaceVO vo) throws Exception{
		return placeDAO.add(vo);
	}
	
	public void updatePlace(PlaceVO vo) throws Exception{
		placeDAO.update(vo);
	}
	
	public void deletePlace(int id) throws Exception{
		placeDAO.delete(id);
	}
}
