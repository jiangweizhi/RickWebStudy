package com.rickwebstudy.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rickwebstudy.entity.Comment;
import com.rickwebstudy.entity.YixinActionLog;
import com.rickwebstudy.entity.YixinLoginLog;
import com.rickwebstudy.entity.YixinUser;
import com.rickwebstudy.repository.CommentRepository;
import com.rickwebstudy.repository.YixinActionLogRepository;
import com.rickwebstudy.repository.YixinLoginLogRepository;
import com.rickwebstudy.repository.YixinUserRepository;
import com.rickwebstudy.service.RickServiceInterface;
import com.rickwebstudy.utils.ImageUtil;

@Service
public class RickServiceImpl implements RickServiceInterface {

	@Inject
	protected CommentRepository commentRepository; 
	@Inject 
	protected YixinUserRepository yixinUserRepository;
	@Inject
	protected YixinLoginLogRepository yixinLoginLogRepository;
	@Inject
	protected YixinActionLogRepository yixinActionLogRepository;
	
	// For Comment functions
	@Override
	public List<Comment> getCommentByJobIdAndStatus(Long jobId, String status) {
		return commentRepository.getByJobIdAndStatus(jobId, status);
	}

	@Override
	public void persistComment(Comment comment) {
		commentRepository.saveAndFlush(comment);
	}

	@Override
	public List<Comment> getComments() {
		return commentRepository.getComments();
	}

	@Override
	@Transactional(readOnly = true)
	public void addPostReqImage(InputStream in,String filePath, String fileName) throws IOException {
		storePostReqImageToFileSystem(fileName,filePath,in);
	}
	
	private String storePostReqImageToFileSystem(String fileName, String filePath, InputStream in){
		FileOutputStream out = null;
        File dir = new File (filePath);
        if (!dir.exists()){
        	dir.mkdir();
        }
        String targetPath =  dir.getPath() + File.separator + fileName;
 
        File picDestination = new File ( targetPath);
        try {
            out = new FileOutputStream( picDestination );
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
        finally {
        	try{
	            if (in != null) {
	                in.close();
	            }
	            if (out != null) {
	                out.close();
	            }
            }catch(Exception e){
            	e.printStackTrace();
            }
        }
        
        return picDestination.getAbsolutePath();
	}

	@Override
	public void createThumbnailImage(float times, String sourceFilePath ,String filePath, String fileName) {
		File dir = new File (filePath);
        if (!dir.exists()){
        	dir.mkdir();
        }
        String targetPath =  dir.getPath() + File.separator + fileName;
		
		ImageUtil.createThumbnailImage(times, sourceFilePath, targetPath);
	}

	
	//For Android Message correction functions
	@Override
	public boolean checkYixinUser(Long deviceId) {
		boolean result = false;
		List<YixinUser> yixinUsers = yixinUserRepository.getYixinUserByDeviceId(deviceId);
		if(yixinUsers.size() > 0){
			result = true;
		}
		
		return result;
	}

	@Override
	public YixinUser getYixinUserByDeviceId(Long deviceId) {
		YixinUser yixinUser = null;
		List<YixinUser> yixinUsers = yixinUserRepository.getYixinUserByDeviceId(deviceId);
		if(yixinUsers.size() > 0){
			yixinUser = yixinUsers.get(0);
		}
		
		return yixinUser;
	}

	@Override
	public void persistYixinUser(YixinUser yixinUser) {
		yixinUserRepository.saveAndFlush(yixinUser);
	}

	@Override
	public void persistYixinLoginLog(YixinLoginLog yixinLoginLog) {
		yixinLoginLogRepository.saveAndFlush(yixinLoginLog);
	}

	@Override
	public void persistYixinActionlog(YixinActionLog yixinActionLog) {
		yixinActionLogRepository.saveAndFlush(yixinActionLog);
	}
	
}
