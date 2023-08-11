package com.myproject.web.persistence;

import java.util.List;

import com.myproject.web.domain.PlaceVO;

public interface PlaceDAO {
	
	public PlaceVO read(int id) throws Exception;
	public List<PlaceVO> readList(int id) throws Exception;
	public int add(PlaceVO vo) throws Exception;
	public void update(PlaceVO vo) throws Exception;
	public void delete(int id) throws Exception;
}
