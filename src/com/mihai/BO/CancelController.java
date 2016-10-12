package com.mihai.BO;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView cancelBook()
	{
		ModelAndView model = new ModelAndView("cancel");
		ReservDataController reservDataController = new ReservDataController();
		List<Reservations> list = reservDataController.getData();
				
		model.addObject("ceva", list);
		
		return model;
	}
	
	@RequestMapping(value = "/cancel.html/{id}", method = RequestMethod.GET)
	public String cancel(@PathVariable String id, Model model)
	{
		ReservDataController reservDataController = new ReservDataController();
		RoomDataController room = new RoomDataController();
		
		Boolean bool = reservDataController.cancelReservation(id);
		
		if(bool)
		{
			String roomName = room.getRoomById(String.valueOf(reservDataController.getReservationById(id).getReservRoomId())).getRoomName();
			model.addAttribute("ok", "Reservation on room " + roomName + " has been canceled with succes");
		}
		else
		{
			model.addAttribute("nameError", "Hey, chief, there's nothing to cancel here!");
		}
		
		List<Reservations> list = reservDataController.getData();
		
		model.addAttribute("ceva", list);
		return "cancel";
		
		
		
	}
}
