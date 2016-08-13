package site.nebulas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import site.nebulas.beans.Exercises;
import site.nebulas.beans.Response;
import site.nebulas.service.ExercisesService;
import site.nebulas.util.DateUtil;



@Controller
public class ExercisesController {
	private Logger logger = LoggerFactory.getLogger(ExercisesController.class);
	
	@Resource 
	private ExercisesService exercisesService; 
	
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813   根据用户名获取题目
	 * 
	 * */
	@RequestMapping("getExercisesByUserAccount")
	@ResponseBody
	public Response getExercisesByUserAccount(){
		Response rs = new Response(); 
		
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		
		Map<String,String> map = exercisesService.getExercisesByUserAccount(userAccount);
		
		if(null == map){
			rs.setStstus(130);
			rs.setMsg("没有题目了");
			return rs;
		}
		
		rs.setStstus(200);
		rs.setMsg("success");
		rs.setData(JSON.toJSONString(map));
		logger.info(map.toString());
		return rs;
	}
	
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813 验证用户提交答案是否正确
	 * */
	@RequestMapping("submitExercises")
	@ResponseBody
	public Response submitExercises(Exercises exercises){
		Response rs = new Response(); 
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		
		//获取用户答案
		String exercisesAnswer = exercises.getExercisesAnswer();
		if(null == exercisesAnswer || "".equals(exercisesAnswer)){
			rs.setStstus(400);
			rs.setMsg("答案不能为空");
			return rs;
		}
		
		//查询正确答案
		Exercises correct = exercisesService.getExercisesById(exercises);
		String correctAnswer = correct.getExercisesAnswer();
		System.out.println("correctAnswer"+correctAnswer);
		//验证答案正确性
		if(exercisesAnswer.equals(correctAnswer)){
			//将答题记录写入数据库
			exercises.setUserAccount(userAccount);
			exercises.setExercisesAnswerTime(DateUtil.getCurrentSysDate());
			exercisesService.insertAnswerRecord(exercises);
			System.out.println("correct");
			rs.setStstus(200);
			rs.setMsg("success");
		}
		return rs;
	}
	
	 
}
