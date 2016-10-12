package com.mihai.BO;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mihai.DAO.ReservDataController;
import com.mihai.DAO.RoomDataController;
import com.mihai.DT.RoomDetails;

@Controller
public class ReservController {

	//========================   CHECK ROOM   ======================================!!!		
	@RequestMapping(value = "/checkRoom.html/{roomId}", method = RequestMethod.GET)
	public ModelAndView checkRoom(@PathVariable String roomId)
	{
		ModelAndView model = new ModelAndView("reservation");
		
		ReservDataController reservDataController = new ReservDataController();
		reservDataController.checkReserv(roomId);
		
		return model;
	}
	
	//=====================================================================================iii
	
	//========================   BOOKING   ======================================!!!		
	@RequestMapping(value = "/bookRoom.html/{roomId}", method = RequestMethod.GET)
	public String bookRoom(@PathVariable String roomId, Model model)
	{
		//ModelAndView model = new ModelAndView("reservation");
		int id = 0;
		
		ReservDataController reservDataController = new ReservDataController();
		RoomDataController roomDataController = new RoomDataController();
		//System.out.println("=========CONTROLbefore=========");
		Boolean bool = reservDataController.bookRoom(roomId); //--the magic of DAO
		
		RoomDetails room = roomDataController.getRoomById(roomId);
		//System.out.println("=========CONTROLafter=========");
		if(bool)
		{
			String roomName = room.getRoomName();
			id = room.getRoomId();
			model.addAttribute("ok", "Room " + roomName + " booked");
		}
		else
		{
			model.addAttribute("nameError", "The room is already reserved!");
		}
		//return "redirect:/reservations.html/" + id;
		//return "/reservations.html/" + id;
		List<RoomDetails> list = roomDataController.getData();
		model.addAttribute("ceva", list);
		return "main";
	}
	
	//=====================================================================================iii
}
