package com.rickwebstudy.service;

import java.util.List;

import com.rickwebstudy.entity.Comment;

public interface RickServiceInterface {
	//For Comment
	public List<Comment> getCommentByJobIdAndStatus(Long jobId, String status);
	public void persistComment(Comment comment);
}
