package com.mihai.BO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mihai.DAO.RoomDataController;
import com.mihai.DAO.UserLoginDataController;
import com.mihai.DT.LoginDetails;
import com.mihai.DT.RoomDetails;

@Controller
public class MainController {

	//========================   REGISTER   ======================================
	@RequestMapping(value = "/register.html", method = RequestMethod.PUT)
	public ModelAndView register()
	{
		ModelAndView model = new ModelAndView("register");
		return model;
		
	}
	
	//========================   HIBERNATE TEST   ========================================!!!
		@RequestMapping(value = "/test.html", method = RequestMethod.GET)
		public ModelAndView hiberTest()
		{
			ModelAndView model = new ModelAndView("main");
			
			UserLoginDataController userLoginDataController = new UserLoginDataController();
			
			userLoginDataController.printData();
			
			return model;
			
		}
	//=====================================================================================iii		
		
	//========================   CONTROLLER RESERV   ======================================!!!		
		@RequestMapping(value = "/reservations.html/{id}", method = RequestMethod.GET)
		public ModelAndView roomGet(@PathVariable String id)
		{
			ModelAndView model = new ModelAndView("main");
			if(!id.equals("empty")){
				RoomDataController roomDataController = new RoomDataController();
				RoomDetails room = roomDataController.getRoomByName(id);
				if(room == null){
					model.addObject("nameError", "The room does not exist");
				}
				else{
					String roomName = room.getRoomName();
					model.addObject("ok", "Room " + roomName + " booked");
				}
				
			}	

				RoomDataController roomDataController = new RoomDataController();
				List<RoomDetails> list = roomDataController.getData();
				model.addObject("ceva", list);
				
				return model;
			
		}
	//=====================================================================================iii
		
		
		/*@RequestMapping(value = "/bookRoom.html/{id}", method = RequestMethod.GET)
		public ModelAndView bookRoom(@PathVariable String id)
		{
			ModelAndView model = new ModelAndView("main");
			
			RoomDataController roomDataController = new RoomDataController();
			String roomName = roomDataController.getRoomById(id).getRoomName();
			
			model.addObject("ok", "Room " + roomName + " booked");
			
			return model;
			
		}*/
		
		//========================   HIBERNATE RESERV TEST   ======================================!!!		
			
			@RequestMapping(value = "/home.html", method = RequestMethod.GET)
			public ModelAndView home()
			{
				ModelAndView model = new ModelAndView();
				return model;
			}
		
		//=====================================================================================iii
		
	
	
}
