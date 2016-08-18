package site.nebulas.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import site.nebulas.service.DailySentenceService;


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
	 * @date 20160810
	 *  练习册页面
	 */
	@RequestMapping("signUp")
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView("signUp");
		return modelAndView;
	}
	
	
	
	
}
