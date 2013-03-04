package com.rickwebstudy.controller;

import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
	
	@RequestMapping(value = "getComment", method=RequestMethod.GET)
	@ResponseBody
	public List<Comment> getComment(){
		List<Comment> listComment = rickService.getComments();
		return listComment;
	}
	
	@RequestMapping(value = "postComment2", method=RequestMethod.POST)
	@ResponseBody
	public List<Comment> postComment2(@RequestParam("commentValue")String commentValue){
		Comment comment = new Comment();
		comment.setContent(commentValue);
		comment.setCreatedAt(Calendar.getInstance().getTime());
		
		rickService.persistComment(comment);
		
		List<Comment> listComment = rickService.getComments();
		
		return listComment;
	}
}
