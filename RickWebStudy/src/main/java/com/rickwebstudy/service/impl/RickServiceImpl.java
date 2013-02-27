package com.rickwebstudy.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rickwebstudy.entity.Comment;
import com.rickwebstudy.repository.CommentRepository;
import com.rickwebstudy.service.RickServiceInterface;

@Service
public class RickServiceImpl implements RickServiceInterface {

	@Inject
	protected CommentRepository commentRepository; 
	
	// For Comment functions
	@Override
	public List<Comment> getCommentByJobIdAndStatus(Long jobId, String status) {
		return commentRepository.getByJobIdAndStatus(jobId, status);
	}

	@Override
	public void persistComment(Comment comment) {
		commentRepository.saveAndFlush(comment);
	}
}
