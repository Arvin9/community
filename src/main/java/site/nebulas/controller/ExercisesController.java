package site.nebulas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

import site.nebulas.beans.Dynamic;
import site.nebulas.beans.Exercises;
import site.nebulas.beans.Response;
import site.nebulas.service.DynamicService;
import site.nebulas.service.ExercisesService;
import site.nebulas.util.DateUtil;



@Controller
public class ExercisesController {
	private Logger logger = LoggerFactory.getLogger(ExercisesController.class);
	
	@Resource 
	private ExercisesService exercisesService;
	@Resource
	DynamicService dynamicService;
	
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813   根据用户名获取题目
	 * 状态码：
	 *    230 成功请求但是没有题目
	 *    200 成功请求并返回题目
	 * */
	@RequestMapping("getExercisesByUserAccount")
	@ResponseBody
	public Response getExercisesByUserAccount(){
		Response rs = new Response(); 
		
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(); 
		String userAccount = (String)subject.getPrincipal();
		
		Map<String,String> map = exercisesService.getExercisesByUserAccount(userAccount);
		
		if(null == map){
			rs.setRet(230);
			rs.setMsg("没有题目了!");
			return rs;
		}
		//插入答题动态
		Dynamic dynamic = new Dynamic();
		dynamic.setUserAccount(userAccount);//用户名
		dynamic.setDynamicLoginIp(session.getHost());//用户登录ip
		dynamic.setDynamicContent("进入答题页面");
		dynamic.setDynamicAddTime(DateUtil.getCurrentSysDate());//动态发生时间
		dynamic.setDynamicTyle(2);//2为答题动态
		dynamicService.insertDynamic(dynamic);
		
		rs.setRet(200);
		rs.setMsg("success");
		rs.setData(JSON.toJSONString(map));
		logger.info(map.toString());
		return rs;
	}
	
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813 验证用户提交答案是否正确
	 * @param exercisesById
	 * 状态码：
	 * 	   200   答案正确
	 * 	   400  答案为空，或不正确
	 * */
	@RequestMapping("submitExercises")
	@ResponseBody
	public Response submitExercises(Exercises exercises){
		Response rs = new Response(); 
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(); 
		String userAccount = (String)subject.getPrincipal();
		
		//获取用户答案
		String exercisesAnswer = exercises.getExercisesAnswer();
		if(null == exercisesAnswer || "".equals(exercisesAnswer)){
			rs.setRet(400);
			rs.setMsg("答案不能为空！");
			return rs;
		}
		
		//查询正确答案
		Exercises correct = exercisesService.getExercisesById(exercises);
		String correctAnswer = correct.getExercisesAnswer();
		//验证答案正确性
		if(exercisesAnswer.equals(correctAnswer)){
			exercises.setUserAccount(userAccount);
			exercises.setExercisesAnswerTime(DateUtil.getCurrentSysDate());
			//将答题正确记录写入数据库
			exercisesService.insertAnswerRecord(exercises);
			//更新答题正确数和答题数
			exercisesService.updateAnswerCorrectValue(exercises);
			//插入答题动态
			Dynamic dynamic = new Dynamic();
			dynamic.setUserAccount(userAccount);//用户名
			dynamic.setDynamicLoginIp(session.getHost());//用户登录ip
			dynamic.setDynamicContent("答对一题");
			dynamic.setDynamicAddTime(DateUtil.getCurrentSysDate());//动态发生时间
			dynamic.setDynamicTyle(2);//2为答题动态
			dynamicService.insertDynamic(dynamic);
			
			rs.setRet(200);
			rs.setMsg("success");
		}else{
			//更新答题数
			exercisesService.updateAnswerValue(exercises);
			rs.setRet(400);
			rs.setMsg("答案错误，请看提示！");
		}
		return rs;
	}
	
	 
}
