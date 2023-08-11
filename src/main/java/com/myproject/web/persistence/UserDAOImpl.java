package com.myproject.web.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.myproject.web.domain.UserVO;
import com.myproject.web.persistence.UserDAO;

@Component
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.myproject.web.mapper.UserMapper";
	
	public UserVO login(UserVO vo) throws Exception{
		UserVO user = sqlSession.selectOne(namespace + ".login", vo);
	    return user;
	}
	
	public UserVO read(String id) throws Exception{
		UserVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;  
	}
	
	public void add(UserVO vo) throws Exception{
		sqlSession.insert(namespace + ".insert", vo);
	}
	
	public void update(UserVO vo) throws Exception{
		sqlSession.update(namespace + ".update", vo);
	}
	
	public void delete(String id) throws Exception{
		sqlSession.delete(namespace + ".delete", id);
	}

}
