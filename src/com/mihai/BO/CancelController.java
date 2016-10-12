package com.mihai.BO;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mihai.DAO.ReservDataController;
import com.mihai.DAO.RoomDataController;
import com.mihai.DT.Reservations;
import com.mihai.DT.RoomDetails;

@Controller
public class CancelController {

	@RequestMapping(value = "/cancel.html", method = RequestMethod.GET)
	public ModelAndView cancelBook(@PathVariable String reservId)
	{
		ModelAndView model = new ModelAndView("cancel");
		
		
		return model;
	}
}
