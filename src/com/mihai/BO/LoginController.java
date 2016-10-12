package com.mihai.BO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
// ===============================================================!!!
// ===============================================================iii

import com.mihai.DAO.UserLoginDataController;
import com.mihai.DT.LoginDetails;

@Controller
public class LoginController {
	
	//http://localhost:8080/SpringRemem/login.html

	//========================   LOG IN VIEW  ======================================
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView getLoginForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		LoginDetails param = (LoginDetails) session.getAttribute("MySessionVar");
		String param2 = (String) session.getAttribute("loggedIn");		
		if(param != null)
		{
			ModelAndView model = new ModelAndView("main");
			model.addObject("jaja", param2);
			return model;
		}
		
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	//========================   SUBMIT LOGIN   ======================================!!!
	@RequestMapping(value = "/submitForm.html", method = RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute("user1") LoginDetails user1, BindingResult result, 
			HttpServletRequest request)
	{
		//====  ERROR CHECKING =====!!!
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("login");
			return model;
		}
		//====  ERROR CHECKING =====iii
		
		
		//=========Some hibernate put testing=====!!!
	
		/*ModelAndView model = new ModelAndView("login");
		UserLoginDataController loginDataController = new UserLoginDataController();
		loginDataController.saveUser(user1);
		
		return model;*/
		
		//=======================================iii
		
		
		//================  Some hibernate get testing   ===========!!!
		/*ModelAndView model = new ModelAndView("login");
		UserLoginDataController loginDataController = new UserLoginDataController();
		List<LoginDetails> usersList = loginDataController.getUserLoginData();
		System.out.println(usersList.get(0).toString());
		model.addObject("noLogin", "This --> " + usersList.get(1).getUser());
		
		
		return model;*/
		//==========================================================iii
		
		
		//===== LOGIN CONDITIONAL HIBERNATE ====!!!
		UserLoginDataController userLoginDataController = new UserLoginDataController();
		List<LoginDetails> users = userLoginDataController.getUserLoginData();
		for(LoginDetails user : users)
		{
			if(user1.getUser().equalsIgnoreCase(user.getUser()) && user1.getPass().equalsIgnoreCase(user.getPass()))
			{
				ModelAndView model = new ModelAndView("home");
				HttpSession session = request.getSession();
				session.setAttribute("MySessionVar", user1);
				session.setAttribute("loggedIn", "Dude, you are already logged in, why do u want to login again");
				return model;
			}
		}
		ModelAndView model = new ModelAndView("login");
		model.addObject("noLogin", "Wrong credentials");
		return model;
		
		//================================iii
		
		
		//========= LOGIN CONDITIONAL  =======!!!
		/*if(user1.getUser().equalsIgnoreCase("mihai") && user1.getPass().equals("1234"))
		{
			ModelAndView model = new ModelAndView("main");
			HttpSession session = request.getSession();
			session.setAttribute("MySessionVar", user1);
			session.setAttribute("loggedIn", "Dude, you are already logged in, why do u want to login again");
			return model;
		}
		else
		{
			ModelAndView model = new ModelAndView("login");
			model.addObject("noLogin", "Wrong credentials");
			return model;
		}*/
		//================================iii
	
	}
	//============================   SUBMIT LOGIN   =============================================iii
	
	
	//========================   LOG OUT   ======================================
	/*@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
		return model;
	}*/
	
	@RequestMapping("/logout.html")
	public String logout(HttpServletRequest request/*, ModelMap model*/)
	{
		/*String jaj = "trololtestiong";
		model.addAttribute("jaj", jaj);
		request.setAttribute("jaj", jaj);*/
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login.html";
		//return "login";
	}
}
