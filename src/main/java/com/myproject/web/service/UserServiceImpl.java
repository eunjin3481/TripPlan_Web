package com.myproject.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.myproject.web.domain.UserVO;
import com.myproject.web.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public UserVO loginUser(UserVO vo) throws Exception{
		return userDAO.login(vo);
	}
	
	public UserVO readUser(String id) throws Exception {
		return userDAO.read(id);
	}
	
	public void addUser(UserVO vo) throws Exception {
		userDAO.add(vo);
	}
	
	public void deleteUser(String id) throws Exception {
		userDAO.delete(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void updateUser(UserVO vo) throws Exception {
		// 사용자의 정보를 변경 작업 중에 예외가 발생한 경우, 롤백 처리를 수행한 후 예외 던짐
		try {

	        userDAO.update(vo);
	        
	    } catch (Exception e) {
	        // 롤백 처리
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	    }
	}
	
}



