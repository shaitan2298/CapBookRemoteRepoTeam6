package com.cg.capbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.CapBookUser;
import com.cg.capbook.exceptions.IncorrectPasswordException;
import com.cg.capbook.exceptions.IncorrectUsernameException;
import com.cg.capbook.services.UserServices;


@Controller
@SessionAttributes("email")
public class LoginController {

	@Autowired
	UserServices userServices;

	@RequestMapping("/loginUser")
	public ModelAndView loginUser(@RequestParam String email, @RequestParam String password, ModelMap model)  throws IncorrectPasswordException, IncorrectUsernameException{ 
		CapBookUser userObj =  userServices.checkPassword(email, password);
		model.put("email", email);
		return new ModelAndView("profilePage");
	}


	//	@RequestMapping("/loginUser")
	//	public ModelAndView loginUser(@ModelAttribute CapBookUser user ,BindingResult result) throws IncorrectPasswordException, IncorrectUsernameException
	//	{
	//		if(result.hasErrors())
	//			return new ModelAndView("login");
	//		user = userServices.loginUser(user);
	//		return new ModelAndView("profilePage","user",user);
	//	}


}
