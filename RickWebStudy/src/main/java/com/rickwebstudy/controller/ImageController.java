package com.rickwebstudy.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rickwebstudy.service.RickServiceInterface;
import com.rickwebstudy.utils.DESUtil;
import com.rickwebstudy.utils.DateUtils;

@Controller
@RequestMapping("/image")
public class ImageController extends AbstractController{
	
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
}
