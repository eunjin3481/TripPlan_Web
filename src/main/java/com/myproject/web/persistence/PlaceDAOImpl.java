package com.myproject.web.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.myproject.web.domain.PlaceVO;
import com.myproject.web.domain.TripVO;

@Component
public class PlaceDAOImpl implements PlaceDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.myproject.web.mapper.PlaceMapper";
	
	public PlaceVO read(int id) throws Exception{
		PlaceVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;   
	}
	
	public List<PlaceVO> readList(int id) throws Exception {
		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		placeList = sqlSession.selectList(namespace + ".selectAll", id);
		return placeList;
	}
	
	public int add(PlaceVO vo) throws Exception{
		sqlSession.insert(namespace + ".insert", vo);
		int placeId = sqlSession.selectOne(namespace + ".getLastInsertId");
		return placeId;
	}
	
	public void update(PlaceVO vo) throws Exception{
		sqlSession.update(namespace + ".update", vo);
	}
	
	public void delete(int id) throws Exception{
		sqlSession.delete(namespace + ".delete", id);
	}

}
