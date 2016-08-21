package site.nebulas.controller;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.nebulas.service.RankService;



@Controller
public class RankController {
	Logger log = LoggerFactory.getLogger(RankController.class);
	
	@Resource
	private RankService rankService;
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * @date 20160821
	 * @return 
	 * 答题排行榜
	 **/
	@RequestMapping("getExercisesRank")
	@ResponseBody
	public Object getExercisesRank() {
		return rankService.getExercisesRank();
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * @date 20160821
	 * @return 
	 * 积分排行榜
	 **/
	@RequestMapping("getIntegralRank")
	@ResponseBody
	public Object getIntegralRank() {
		return rankService.getIntegralRank();
	}
}




