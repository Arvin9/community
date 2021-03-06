package site.nebulas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.nebulas.beans.DailySentence;
import site.nebulas.beans.Dynamic;
import site.nebulas.beans.MessageBoard;
import site.nebulas.beans.Response;
import site.nebulas.service.DailySentenceService;
import site.nebulas.service.DynamicService;
import site.nebulas.service.MessageBoardService;
import site.nebulas.util.DateUtil;



@Controller
public class MessageBoardController {
	private Logger log = LoggerFactory.getLogger(MessageBoardController.class);
	
	@Resource 
	private MessageBoardService messageBoardService;
	@Resource
	DynamicService dynamicService;
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 获得留言板所有内容
	 */
	@RequestMapping("getMessageBoard")
	@ResponseBody
	public List<MessageBoard> getMessageBoard(MessageBoard messageBoard){		
		return messageBoardService.getMessageBoard(messageBoard);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 提交留言内容,写入数据库
	 */
	@RequestMapping("submitMessage")
	@ResponseBody
	public void submitMessage(MessageBoard messageBoard){
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		messageBoard.setMessageBoardLoginIp(session.getHost());//用户登录ip
		String userAccount = (String)subject.getPrincipal();
		//插入数据
		if (null == userAccount){
			messageBoard.setUserAccount("游客");
		}else{
			messageBoard.setUserAccount(userAccount);//用户名
		}
		messageBoard.setMessageBoardSupport(0);
		messageBoard.setMessageBoardAddTime(DateUtil.getCurrentSysDate());//留言时间
		messageBoardService.insertMessageBoard(messageBoard);
		
		//插入留言动态
		Dynamic dynamic = new Dynamic();
		dynamic.setUserAccount(messageBoard.getUserAccount());//用户名
		dynamic.setDynamicLoginIp(session.getHost());//用户登录ip
		dynamic.setDynamicContent("在留言板留言啦，快来看看写了些什么!");
		dynamic.setDynamicAddTime(DateUtil.getCurrentSysDate());//动态发生时间
		dynamic.setDynamicTyle(3);//3为留言动态
		dynamicService.insertDynamic(dynamic);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 提交留言点赞信息,写入数据库并更新留言板点赞人数
	 */
	@RequestMapping("submitMessageSupport")
	@ResponseBody
	public void submitMessageSupport(MessageBoard messageBoard){
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		messageBoard.setMessageBoardSupportLoginIp(session.getHost());//留言点赞用户登录ip
		String userAccount = (String)subject.getPrincipal();
		//插入数据
		if (null == userAccount){
			messageBoard.setUserAccount("游客");
		}else{
			messageBoard.setUserAccount(userAccount);//留言点赞用户名
		}
		messageBoard.setMessageBoardSupportTime(DateUtil.getCurrentSysDate());//留言点赞时间
		messageBoardService.insertMessageBoardSupport(messageBoard); //插入留言板用户点赞信息
		messageBoardService.updateMessageBoard(messageBoard); //更新留言板的点赞数量
		
		//插入点赞留言动态
		Dynamic dynamic = new Dynamic();
		dynamic.setUserAccount(messageBoard.getUserAccount());//用户名
		dynamic.setDynamicLoginIp(session.getHost());//用户登录ip
		dynamic.setDynamicContent("在点赞了留言,来围观下哪条最赞!");
		dynamic.setDynamicAddTime(DateUtil.getCurrentSysDate());//动态发生时间
		dynamic.setDynamicTyle(4);//4为点赞动态
		dynamicService.insertDynamic(dynamic);
	}
}
