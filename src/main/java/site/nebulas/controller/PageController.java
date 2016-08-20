package site.nebulas.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import site.nebulas.beans.LogAskRobot;
import site.nebulas.service.DailySentenceService;
import site.nebulas.service.LogAskRobotService;
import site.nebulas.util.DateUtil;
import site.nebulas.util.RobotUtil;


/**
 * @author CaiHonghui
 * @since 20160810
 * 所有页面的控制层
 * 
 */
@Controller
public class PageController {
	private Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Resource 
	private DailySentenceService dailySentenceService; 
	
	@Resource 
	private LogAskRobotService logAskRobotService;
	
	/**
	 * @author CaiHonghui
	 * @date 20160810
	 *  首页
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20160810
	 *  登陆页面
	 */
	@RequestMapping("login")
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	
	/**
	 * @author CaiHonghui
	 * @date 20160810
	 *  练习册页面
	 */
	@RequestMapping("exercises")
	public ModelAndView exercises(){
		ModelAndView modelAndView = new ModelAndView("exercises");
		return modelAndView;
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20160819
	 *  注册页面
	 */
	@RequestMapping("signUp")
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView("signUp");
		return modelAndView;
	}
	/**
	 * @author CaiHonghui
	 * @date 20160820
	 *  客服机器人页面
	 */
	@RequestMapping("serviceRobot")
	public String serviceRobot(){
		return "serviceRobot";
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20160820
	 * @param message
	 * @return {"code":100000,"text":"您好，我是客服机器人，有什么可以帮您的吗？"}
	 *  客服机器人页面
	 */
	@RequestMapping(value="askRobot",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String askRobot(String message){
		LogAskRobot logAskRobot = new LogAskRobot();
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		//插入数据
		if (null == userAccount){
			logAskRobot.setUserAccount("游客");
		}else{
			logAskRobot.setUserAccount(userAccount);
		}
		logAskRobot.setLogAskRobotContent(message);
		logAskRobot.setLogAskRobotTime(DateUtil.getCurrentSysDate());
		logAskRobotService.insert(logAskRobot);
		return RobotUtil.askRobot(message);
	}
	
	
}
