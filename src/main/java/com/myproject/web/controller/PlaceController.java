package com.myproject.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myproject.web.domain.PlaceVO;
import com.myproject.web.service.PlaceService;

@Controller
@RequestMapping(value = "/trip")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	private static final Logger logger = LoggerFactory.getLogger(TripController.class);
	
	// 장소 추가
	@RequestMapping(value = { "/{tripId}/place" }, method = RequestMethod.POST)
	public String createTripGet(@PathVariable("tripId") int tripId, @ModelAttribute("place") PlaceVO vo, Model model) throws Exception {
		vo.setTripId(tripId);
		placeService.addPlace(vo);
		model.addAttribute("tripId", tripId);
		return "redirect:/tripUpdate";
	}
	
	// 장소 수정
	@RequestMapping(value = { "/{tripId}/placeUpdate/{placeId}" }, method = RequestMethod.POST)
	public String createTripPost(@PathVariable("tripId") int tripId, @PathVariable("placeId") int placeId, @ModelAttribute("place") PlaceVO vo, Model model) throws Exception {
		vo.setPlaceId(placeId);
		placeService.updatePlace(vo);
		model.addAttribute("tripId", tripId);
		return "redirect:/tripUpdate";
	}
	
	// 장소 삭제
	@RequestMapping(value= {"/{tripId}/placeDelete/{placeId}"}, method=RequestMethod.GET)
	public String  deleteUser(@PathVariable("tripId") int tripId, @PathVariable("placeId") int placeId, Model model) throws Exception{
		placeService.deletePlace(placeId);
		model.addAttribute("tripId", tripId);
		return "redirect:/tripUpdate";
	}

}
