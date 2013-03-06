package com.rickwebstudy.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rickwebstudy.service.RickServiceInterface;
import com.rickwebstudy.utils.DESUtil;
import com.rickwebstudy.utils.DateUtils;

@Controller
@RequestMapping("/image")
public class ImageController extends AbstractController{
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Inject
	RickServiceInterface rickService;
	
	@RequestMapping(value = "resize", method=RequestMethod.POST)
	public ModelAndView resizeImage(@RequestParam MultipartFile[] uploadFile, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("home");
		String originalPath = request.getSession().getServletContext().getRealPath("/original/");
		String thumbnailPath = request.getSession().getServletContext().getRealPath("/thumbnail/");
		for (int i = 0; i < uploadFile.length; i++) {
			if (!uploadFile[i].isEmpty()) {
				String fileName = DateUtils.getFileNameByCurrentDate(Calendar.getInstance())+"_"+
						((CommonsMultipartFile) uploadFile[i]).getOriginalFilename();
				String suffix = fileName.substring(fileName.lastIndexOf('.')+1);
				fileName = DESUtil.encrypt(fileName.substring(0, fileName.lastIndexOf('.')), "");
				fileName += "." + suffix;
				try {
					rickService.addPostReqImage(
							uploadFile[i].getInputStream(), originalPath, fileName);
					
					rickService.createThumbnailImage(0.1f, originalPath+File.separator+fileName, 
							thumbnailPath, fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return mav;
	}
	
	@RequestMapping(value="move", method=RequestMethod.POST)
	public ModelAndView moveFile(@RequestParam("fileName")String fileName, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("home");
		
		String tempPath = request.getSession().getServletContext().getRealPath("/temp/");
		String originalPath = request.getSession().getServletContext().getRealPath("/original/");
		String thumbnailPath = request.getSession().getServletContext().getRealPath("/thumbnail/");
		List<String> fileNameList = Arrays.asList(fileName.split(";"));
		for (Iterator<String> iterator = fileNameList.iterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			
			rickService.createThumbnailImage(0.2f, tempPath + File.separator + name, 
					thumbnailPath, name);
			
			File oldFile = new File(tempPath + File.separator + name); 
			File fnewpath = new File(originalPath); 
			File newFile = new File(originalPath + File.separator + name); 
			if(!fnewpath.exists()){
				newFile.mkdirs(); 
			}
			oldFile.renameTo(newFile);
		}
		
		
		
		return mav;
	}
	
	@RequestMapping(value="rick", method=RequestMethod.POST)
	@ResponseBody
	public String postHandler(HttpServletRequest request) {
		String fileName = "";
		String suffix = "";
		String tempPath = request.getSession().getServletContext().getRealPath("/temp/");
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		
		for (Iterator<String> it = multipartRequest.getFileNames(); it.hasNext();) { 
			String key = (String)it.next();  
            MultipartFile file = multipartRequest.getFile(key);  
            
            fileName = DateUtils.getFileNameByCurrentDate(Calendar.getInstance())+"_"+
            		file.getOriginalFilename();
            suffix = fileName.substring(fileName.lastIndexOf('.')+1);
			fileName = DESUtil.encrypt(fileName.substring(0, fileName.lastIndexOf('.')), "");
			fileName += "." + suffix;
            try {
				rickService.addPostReqImage(file.getInputStream(), tempPath, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
            
            logger.error(file.getOriginalFilename());
		}
		
		return fileName;
	}
}
