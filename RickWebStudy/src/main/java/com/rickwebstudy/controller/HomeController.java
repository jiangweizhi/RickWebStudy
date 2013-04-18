package com.rickwebstudy.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rickwebstudy.service.RickServiceInterface;

@Controller
@RequestMapping("/")
public class HomeController extends AbstractController{
	@Inject
	protected RickServiceInterface rickService;
	
	@RequestMapping(value = "image", method=RequestMethod.GET)
	public ModelAndView commentResult(){
		ModelAndView mav = new ModelAndView("ImageFunction");
		
		return mav;
	}
	
	@RequestMapping(value = "test", method=RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView("test");
		
		return mav;
	}
	
	@RequestMapping(value = "test2", method=RequestMethod.GET)
	public ModelAndView test2(){
		ModelAndView mav = new ModelAndView("test2");
		
		return mav;
	}
	
}
