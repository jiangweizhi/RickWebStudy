package com.rickwebstudy.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rickwebstudy.entity.YixinActionLog;
import com.rickwebstudy.entity.YixinLoginLog;
import com.rickwebstudy.entity.YixinUser;
import com.rickwebstudy.service.RickServiceInterface;

@Controller
@RequestMapping("/androidlog")
public class AndroidLogController extends AbstractController{
	@Inject
	protected RickServiceInterface rickService;
	
	@RequestMapping(value = "checkuser", method=RequestMethod.POST)
	@ResponseBody
	public String checkUser(HttpServletRequest request){
		String result = "";
		Long deviceId = Long.parseLong(request.getParameter("deviceId"));
		String deviceModel = request.getParameter("deviceModel");
		if(!rickService.checkYixinUser(deviceId)){
			YixinUser yixinUser = new YixinUser();
			yixinUser.setDeviceId(deviceId);
			yixinUser.setDeviceModel(deviceModel);
			rickService.persistYixinUser(yixinUser);
			
			result = "Add Successfully";
		}
		
		return result;
	}
	
	@RequestMapping(value = "loginlog", method=RequestMethod.POST)
	@ResponseBody
	public String loginLog(HttpServletRequest request){
		String result = "Success";
		
		Long deviceId = Long.parseLong(request.getParameter("deviceId"));
		String ipAddress = request.getParameter("ipAddress");
		String createTime = request.getParameter("createTime");
		String updateTime = request.getParameter("updateTime");
		
		YixinUser yixinUser = rickService.getYixinUserByDeviceId(deviceId);
		
		YixinLoginLog yixinLoginLog = new YixinLoginLog();
		yixinLoginLog.setIpAddress(ipAddress);
		yixinLoginLog.setCreateTime(createTime);
		yixinLoginLog.setUpdateTime(updateTime);
		yixinLoginLog.setOwner(yixinUser);
		
		rickService.persistYixinLoginLog(yixinLoginLog);
		
		return result;
	}
	
	@RequestMapping(value = "actionlog", method=RequestMethod.POST)
	@ResponseBody
	public String actionLog(HttpServletRequest request){
		String result = "Success";
		
		Long deviceId = Long.parseLong(request.getParameter("deviceId"));
		String groupName = request.getParameter("groupName");
		String typeName = request.getParameter("typeName");
		String article = request.getParameter("article");
		String createTime = request.getParameter("createTime");
		String updateTime = request.getParameter("updateTime");
		
		YixinUser yixinUser = rickService.getYixinUserByDeviceId(deviceId);
		
		YixinActionLog yixinActionLog = new YixinActionLog();
		yixinActionLog.setGroupName(groupName);
		yixinActionLog.setTypeName(typeName);
		yixinActionLog.setArticle(article);
		yixinActionLog.setCreateTime(createTime);
		yixinActionLog.setUpdateTime(updateTime);
		yixinActionLog.setOwner(yixinUser);
		
		rickService.persistYixinActionlog(yixinActionLog);
		
		return result;
	}
}
