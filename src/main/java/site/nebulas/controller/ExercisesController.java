package site.nebulas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import site.nebulas.beans.Exercises;
import site.nebulas.beans.Response;
import site.nebulas.service.DailySentenceService;
import site.nebulas.service.ExercisesService;



@Controller
public class ExercisesController {
	private Logger logger = LoggerFactory.getLogger(ExercisesController.class);
	
	@Resource 
	private ExercisesService exercisesService; 
	
	
	@RequestMapping("getExercisesByParm")
	@ResponseBody
	public String getExercisesByParm(Exercises exercises){
		logger.debug(exercisesService.getExercisesByParm(exercises).toString());
		return JSON.toJSONString(exercisesService.getExercisesByParm(exercises));
	}
	
	@RequestMapping("getExercisesByUserAccount")
	@ResponseBody
	public Response getExercisesByUserAccount(String userAccount){
		Response rs = new Response(); 
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
	
	 
}
