package com.myproject.web.service;

import com.myproject.web.domain.UserVO;

public interface UserService {
	public UserVO loginUser(UserVO vo) throws Exception;
	public UserVO readUser(String id) throws Exception;
	public void addUser(UserVO vo) throws Exception;
	public void updateUser(UserVO vo) throws Exception;
	public void deleteUser(String id) throws Exception;
}
