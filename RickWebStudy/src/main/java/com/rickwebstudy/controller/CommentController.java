package com.rickwebstudy.controller;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rickwebstudy.entity.Comment;
import com.rickwebstudy.service.RickServiceInterface;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController{
	
	@Inject
	protected RickServiceInterface rickService;
	
	@RequestMapping(value = "postComment")
	public ModelAndView postComment(@RequestParam("commentValue")String commentValue){
		ModelAndView mav = new ModelAndView("CommentResult");
		
		Comment comment = new Comment();
		comment.setContent(commentValue);
		comment.setCreatedAt(Calendar.getInstance().getTime());
		
		rickService.persistComment(comment);
		
		return mav;
	}
	
	@RequestMapping(value = "commentResult", method=RequestMethod.GET)
	public ModelAndView commentResult(){
		ModelAndView mav = new ModelAndView("CommentResult");
		
		return mav;
	}
}
