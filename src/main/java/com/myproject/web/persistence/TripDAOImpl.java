package com.myproject.web.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.myproject.web.persistence.TripDAO;
import com.myproject.web.domain.TripVO;


@Component
public class TripDAOImpl implements TripDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.myproject.web.mapper.TripMapper";
	
	public List<TripVO> readList() throws Exception {
		List<TripVO> triplist = new ArrayList<TripVO>();
		triplist = sqlSession.selectList(namespace + ".selectAll");
		return triplist;
	}
	
	public List<TripVO> readUserList(String userId) throws Exception{
		List<TripVO> triplist = new ArrayList<TripVO>();
		triplist = sqlSession.selectList(namespace + ".userSelectAll", userId);
		return triplist;
	}
	
	public TripVO read(int id) throws Exception{
		
		TripVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;   
	}
	
	public int add(TripVO vo) throws Exception{
		sqlSession.insert(namespace + ".insert", vo);
		int tripId = sqlSession.selectOne(namespace + ".getLastInsertId");
		return tripId;
	}
	
	public void update(TripVO vo) throws Exception{
		sqlSession.update(namespace + ".update", vo);
	}
	
	public void delete(int id) throws Exception{
		sqlSession.delete(namespace + ".delete", id);
	}
}

