package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@GetMapping(value = "/home")
	public ModelAndView firstView()
	{
	    ModelAndView mav = new ModelAndView("home"); 
	    return mav;
	}
	
	@GetMapping(value = "/scoreboard")
	public ModelAndView thirdView()
	{
	    ModelAndView mav = new ModelAndView("scoreboard"); 
	    return mav;
	}
	
	@GetMapping(value = {"", "/", "/login-register"})
	public ModelAndView secondView()
	{
	    ModelAndView mav = new ModelAndView("login"); 
	    return mav;
	}
	
	

}
