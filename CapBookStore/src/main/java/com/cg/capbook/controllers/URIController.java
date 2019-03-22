package com.cg.capbook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.capbook.beans.CapBookUser;

@Controller
public class URIController 
{
	public CapBookUser user;
	
   @RequestMapping(value= {"/","index"})
   public String getIndexPage()
   {
	   return "indexPage";
   }
   
   @RequestMapping("/registration")
   public String getRegistration()
   {
	   return "registrationPage";
   }
   
   @RequestMapping("/login")
   public String getLogin()
   {
	   return "login";
   }
   @RequestMapping("/start")
   public String getStart()
   {
	   return "start";
   }
   
   @RequestMapping("/forgetpass")
   public String getforgetpass()
   {
	   return "forgetPasswordPage";
   }
   
   @RequestMapping("/setPassword")
   public String getsetPassword()
   {
	   return "setNewPasswordPage";
   }
  
   
   @ModelAttribute
   public CapBookUser getCapBookUser() {
	   user = new CapBookUser();
	   return user;
   }
  
}
