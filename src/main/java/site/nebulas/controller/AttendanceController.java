package site.nebulas.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.nebulas.beans.Attendance;
import site.nebulas.beans.DailySentence;
import site.nebulas.beans.Response;
import site.nebulas.service.AttendanceService;
import site.nebulas.service.DailySentenceService;
import site.nebulas.util.DateUtil;



@Controller
public class AttendanceController {
	private Logger log = LoggerFactory.getLogger(AttendanceController.class);
	
	@Resource 
	private AttendanceService attendanceService; 
	
	/**
	 * @author Honghui
	 * 执行签到
	 */
	@RequestMapping("checkIn")
	@ResponseBody
	public Object checkIn(Attendance attendance){
		Response rs = new Response();
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();

		if (null == userAccount){
			//未登陆
			rs.setRet(400);
			rs.setMsg("notLogin");
			return rs;
		}
		attendance.setUserAccount(userAccount);
		attendance.setAttendanceAddTime(DateUtil.getDate());
		//已登陆，执行签到动作
		if(!attendanceService.checkIn(attendance)){
			//签到失败
			rs.setRet(400);
			rs.setMsg("fail");
			return rs;
		}
		
		rs.setRet(200);
		rs.setMsg("success");
		return rs;
	}
	
	/**
	 * @author CaiHonghui
	 * 查询是否签到
	 */
	@RequestMapping("isCheckIn")
	@ResponseBody
	public Object isCheckIn(Attendance attendance){
		Response rs = new Response();
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();

		if (null == userAccount){
			//未登陆
			rs.setRet(400);
			rs.setMsg("notLogin");
			return rs;
		}
		attendance.setUserAccount(userAccount);
		attendance.setAttendanceAddTime(DateUtil.getDate());
		if(null == attendanceService.getByAddTime(attendance)){
			//未签到
			rs.setRet(200);
			rs.setMsg("no");
			return rs;
		}
		
		rs.setRet(200);
		rs.setMsg("yes");
		return rs;
	}
}
