package com.myproject.web.persistence;

import com.myproject.web.domain.UserVO;

public interface UserDAO {
	public UserVO login(UserVO vo) throws Exception;
	public UserVO read(String id) throws Exception;
	public void add(UserVO vo) throws Exception;
	public void update(UserVO vo) throws Exception;
	public void delete(String id) throws Exception;
}
