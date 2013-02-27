package com.rickwebstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController{
	
	@RequestMapping("postComment")
	public ModelAndView postComment(){
		ModelAndView mav = new ModelAndView("/index.jsp");
		
		return mav;
	}
}
