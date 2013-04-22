package com.rickwebstudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/androidversion")
public class AndroidVersionController {
	
	@RequestMapping(value = "checkversion", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView checkversion(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("YixinAppVersion");
		
		response.setContentType("application/xml");
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		
		return mav;
	}
}
