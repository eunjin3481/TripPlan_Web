package com.myproject.web.persistence;

import java.util.List;

import com.myproject.web.domain.TripVO;

public interface TripDAO {
	public List<TripVO> readList() throws Exception;
	public List<TripVO> readUserList(String userId) throws Exception;
	public TripVO read(int id) throws Exception;
	public int add(TripVO vo) throws Exception;
	public void update(TripVO vo) throws Exception;
	public void delete(int id) throws Exception;
}
