package com.rickwebstudy.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.rickwebstudy.entity.Comment;
import com.rickwebstudy.entity.YixinActionLog;
import com.rickwebstudy.entity.YixinLoginLog;
import com.rickwebstudy.entity.YixinUser;

public interface RickServiceInterface {
	//For Comment
	public List<Comment> getCommentByJobIdAndStatus(Long jobId, String status);
	public List<Comment> getComments();
	public void persistComment(Comment comment);
	public void addPostReqImage(InputStream in, String filePath, String fileName) throws IOException;
	public void createThumbnailImage(float times, String sourceFilePath, String filePath, String fileName);
	
	//For Android Message correct functions
	public boolean checkYixinUser(Long deviceId);
	public YixinUser getYixinUserByDeviceId(Long deviceId);
	public void persistYixinUser(YixinUser yixinUser);
	public void persistYixinLoginLog(YixinLoginLog yixinLoginLog);
	public void persistYixinActionlog(YixinActionLog yixinActionLog);
}
