package site.nebulas.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import site.nebulas.service.DailySentenceService;
import site.nebulas.service.ExercisesService;



@Controller
public class ExercisesController {
	private Logger logger = LoggerFactory.getLogger(ExercisesController.class);
	
	@Resource 
	private ExercisesService exercisesService; 
	
	
	@RequestMapping("getExercisesByUserAccount")
	@ResponseBody
	public String getExercisesByUserAccount(String userAccount){
		System.out.println(userAccount);
		logger.debug(exercisesService.getExercisesByParm(null).toString());
		
		return JSON.toJSONString(exercisesService.getExercisesByParm(null));
	}
	
	 
}
