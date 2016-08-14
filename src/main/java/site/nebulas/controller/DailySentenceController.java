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

import site.nebulas.beans.DailySentence;
import site.nebulas.beans.Response;
import site.nebulas.service.DailySentenceService;
import site.nebulas.util.DateUtil;



@Controller
public class DailySentenceController {
	private Logger logger = LoggerFactory.getLogger(DailySentenceController.class);
	
	@Resource 
	private DailySentenceService dailySentenceService; 
	
	/**
	 * @author CaiHonghui
	 * @version 0.2
	 * 20160813 以展示次数为升序，查出一条DailySentence
	 */
	@RequestMapping("getDailySentence")
	@ResponseBody
	public Object getDailySentence(){		
		return dailySentenceService.getDailySentence();
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160813 插入一条dailySentenceLike数据
	 */
	@RequestMapping("dailySentenceLike")
	@ResponseBody
	public Object dailySentenceLike(DailySentence dailySentence){
		Response rs = new Response();
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		//插入数据
		dailySentence.setDailySentenceHobbyAddTime(DateUtil.getCurrentSysDate());
		dailySentence.setDailySentenceHobby(1);//喜欢设置为1
		dailySentence.setUserAccount(userAccount);
		dailySentenceService.insertDailySentenceHobby(dailySentence);
		//更新dailySentenceShowTimes
		dailySentenceService.updateDailySentence(dailySentence);
		
		rs.setRet(200);
		rs.setMsg("success");
		return rs;
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160813 插入一条dailySentenceDislike数据
	 */
	@RequestMapping("dailySentenceDislike")
	@ResponseBody
	public Object dailySentenceDislike(DailySentence dailySentence){
		Response rs = new Response();
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		//插入数据
		dailySentence.setDailySentenceHobbyAddTime(DateUtil.getCurrentSysDate());
		dailySentence.setDailySentenceHobby(2);//不喜欢设置为2
		dailySentence.setUserAccount(userAccount);
		dailySentenceService.insertDailySentenceHobby(dailySentence);
		//更新dailySentenceShowTimes
		dailySentenceService.updateDailySentence(dailySentence);
		
		rs.setRet(200);
		rs.setMsg("success");
		return rs;
	}
	
}
