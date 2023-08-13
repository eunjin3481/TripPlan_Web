package com.myproject.web.controller;
import com.myproject.web.controller.*;
import com.myproject.web.service.UserService;
import com.myproject.web.domain.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	
	@Autowired
    private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(TripController.class);

	// 로그인 화면 
	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	public String loginGet() throws Exception{
		return "pages/login";
	}
	
	// 로그인 
	@RequestMapping(value= {"/login"}, method=RequestMethod.POST)
	public String loginPost(@RequestParam("id") String id, @RequestParam("passwd") String passwd, HttpServletRequest request)  throws Exception{
		UserVO vo = new UserVO();
		vo.setUserId(id);
		vo.setUserPasswd(passwd);
		UserVO user = userService.loginUser(vo);
		
		// 로그인 실패
		if(user == null) {
			return "redirect:/login";
		}
		// 로그인 성공
		else {
			HttpSession session = request.getSession(); // 세션 생성 또는 기존 세션 반환
			session.setAttribute("userId", user.getUserId()); // 세션에 데이터 저장
			return "redirect:/";
		}
	}
	
	// 로그아웃
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}

	// 회원가입 화면 
	@RequestMapping(value= {"/join"}, method=RequestMethod.GET)
	public String signupGet() throws Exception{
		return "pages/join";
	}
	
	// 회원가입 
	@RequestMapping(value= {"/join"}, method=RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") UserVO vo)  throws Exception{
		userService.addUser(vo);
		return "redirect:/login";
	}
	
	// 회원정보 조회 
	@RequestMapping(value= {"/user"}, method=RequestMethod.GET)
	public String readUser(Model model, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(); // 세션 생성 또는 기존 세션 반환
		String userId = (String) session.getAttribute("userId");
		UserVO user = userService.readUser(userId);
		model.addAttribute("user", user);
		if(userId != null) {
			return "pages/profile";
		}
		else {
			return "redirect:/";
		}
	}
	
	// 회원정보 수정 
	@RequestMapping(value= {"/userUpdate"}, method=RequestMethod.POST)
	public String modifyUserPost(@ModelAttribute("user") UserVO vo) throws Exception{
		userService.updateUser(vo);
		return "redirect:/user";
	}
		
	
	// 회원정보 삭제
	@RequestMapping(value= {"/userDelete"}, method=RequestMethod.GET)
	public String deleteUser(@RequestParam("userId") String userId, HttpServletRequest request) throws Exception{
		userService.deleteUser(userId);
		HttpSession session = request.getSession(); 
		session.invalidate();
		return "redirect:/";
	}
	
	
}