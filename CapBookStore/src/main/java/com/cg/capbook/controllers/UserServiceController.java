package com.cg.capbook.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.CapBookUser;
import com.cg.capbook.exceptions.IncorrectAnswerException;
import com.cg.capbook.exceptions.IncorrectPasswordException;
import com.cg.capbook.exceptions.IncorrectUsernameException;
import com.cg.capbook.exceptions.NewPasswordSimilarToOldException;
import com.cg.capbook.exceptions.PasswordMismatchException;
import com.cg.capbook.services.UserServices;

@Controller
@SessionAttributes("email1")

public class UserServiceController
{
	@Autowired
	UserServices userServices;

	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute CapBookUser user,BindingResult result)
	{
		if(result.hasErrors())
			return new ModelAndView("registrationPage");
		user = userServices.acceptUserDetails(user);
		return new ModelAndView("login","user",user);
	}
	
	@RequestMapping("/forgetPassword")
	public ModelAndView forgetPassword(@RequestParam String email1,ModelMap model1) throws IncorrectUsernameException
	{	
		model1.put("email1", email1);
		CapBookUser user = userServices.forgetPassword(email1);
		return new ModelAndView("forgetPasswordSecurityQuestionPage","user",user);
	}
	
	@RequestMapping("/forgetPasswordSuccess")
	public ModelAndView forgetPasswordSuccess(@SessionAttribute("email1") String email1, @RequestParam String securityAnswer) throws IncorrectUsernameException, IncorrectAnswerException
	{	
		boolean result = userServices.checkSecurityAnswer(email1,securityAnswer);
		return new ModelAndView("forgetPasswordSuccessPage","email1",email1);
	}
	
	@RequestMapping("/changePassword")
	public ModelAndView changePassword(@SessionAttribute("email1") String email1,@RequestParam String newPassword,@RequestParam String confirmPassword) throws IncorrectUsernameException, IncorrectAnswerException, PasswordMismatchException
	{	
		boolean result = userServices.changeForgettedPassword(email1,newPassword,confirmPassword);
		return new ModelAndView("forgetPasswordSuccessPage","result",result);
	}
	
	@RequestMapping("/setNewPassword")
	public ModelAndView setNewPassword(@SessionAttribute("email") String email,@RequestParam String oldPassword, @RequestParam String newPassword,@RequestParam String confirmPassword) throws IncorrectUsernameException, IncorrectAnswerException, PasswordMismatchException, NewPasswordSimilarToOldException
	{	
		boolean result = userServices.setNewPassword(email,oldPassword,newPassword,confirmPassword);
		return new ModelAndView("setNewPasswordPage","result",result);
	}
	
	@RequestMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile)
	{
		String returnValue="start";
		try {
			userServices.saveImage(imageFile);
		} catch (IOException e) {
			
			e.printStackTrace();
			returnValue="error";
		}
		return returnValue;
	}
	@RequestMapping("/loggingout")
	public String getlogout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
