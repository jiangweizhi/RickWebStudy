package com.rickwebstudy.repository.custom;

import java.util.List;

import com.rickwebstudy.entity.Comment;

public interface CommentRepositoryCustom {
	List<Comment> getByCommentId(Long commentId);
	List<Comment> getByJobId(Long jobId);
	List<Comment> getByJobIdAndStatus(Long jobId, String status);
	List<Comment> getByUserId(Long userId);
}
