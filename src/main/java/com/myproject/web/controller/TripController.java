package com.myproject.web.controller;

import com.myproject.web.service.PlaceService;
import com.myproject.web.service.TripService;
import com.myproject.web.domain.PlaceVO;
import com.myproject.web.domain.TripVO;

import java.util.List;

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
public class TripController {

	@Autowired
	private TripService tripService;
	
	@Autowired
	private PlaceService placeService;

	private static final Logger logger = LoggerFactory.getLogger(TripController.class);

	// 여행 목록 조회 
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listTrip(Model model) throws Exception {
		List<TripVO> trips = tripService.readTripList();
		model.addAttribute("trips", trips);
		return "pages/main";
	}

	// 여행 조회
	@RequestMapping(value = "/trip", method = RequestMethod.GET)
	public String readTrip(@RequestParam("tripId") int tripId, Model model) throws Exception {
		TripVO trip = tripService.readTrip(tripId);
		model.addAttribute("trip", trip);
		//model.addAttribute("num", 1); -> 페이지 다르게
		return "pages/tripPlan";
	}

	// 여행 생성
	@RequestMapping(value = { "/tripCreate" }, method = RequestMethod.POST)
	public String createTripGet(@RequestParam("title") String title, Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		// 로그인했을 경우
		if (userId != null) {
			TripVO vo = new TripVO();
			vo.setUserId(userId);
			vo.setTripTitle(title);
			vo.setState("private");
			
			
			int tripId = tripService.addTrip(vo);
			TripVO trip = tripService.readTrip(tripId);
			model.addAttribute("trip", trip);
			return "pages/tripPlan";
		}
		
		// 로그인을 안했을 경우
		else {
			return "redirect:/";
		}
	}
	


	// 여행 수정 화면
	@RequestMapping(value = { "/tripUpdate" }, method = RequestMethod.GET)
	public String modifyTripGet(@RequestParam("tripId") int tripId, Model model) throws Exception {
		TripVO trip = tripService.readTrip(tripId);
		List<PlaceVO> places = placeService.readPlaceList(tripId);
		
		model.addAttribute("trip", trip);
		model.addAttribute("places", places);
		
		//model.addAttribute("num", 0); -> 페이지 다르게 하기
		return "pages/tripPlan";
	}

	// 여행 수정
	@RequestMapping(value = { "/tripUpdate" }, method = RequestMethod.POST)
	public String modifyTripPost(@ModelAttribute("trip") TripVO vo) throws Exception {
		tripService.updateTrip(vo);
		return "redirect:/user";
	}

	// 여행 삭제
	@RequestMapping(value = { "/tripDelete" }, method = RequestMethod.GET)
	public String deleteTrip(@RequestParam("tripId") int tripId) throws Exception {
		tripService.deleteTrip(tripId);
		return "redirect:/user";
	}

}
