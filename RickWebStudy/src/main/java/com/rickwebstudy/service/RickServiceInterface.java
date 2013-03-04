package com.rickwebstudy.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.rickwebstudy.entity.Comment;

public interface RickServiceInterface {
	//For Comment
	public List<Comment> getCommentByJobIdAndStatus(Long jobId, String status);
	public List<Comment> getComments();
	public void persistComment(Comment comment);
	public void addPostReqImage(InputStream in, String filePath, String fileName) throws IOException;
	public void createThumbnailImage(float times, String sourceFilePath, String filePath, String fileName);
}
