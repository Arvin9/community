package site.nebulas.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import site.nebulas.dao.RankDao;


@Service
public class RankService {
	@Resource
	private RankDao rankDao;
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * @date 20160821
	 * @return 
	 * 答题排行榜
	 **/
	public List<Map<String,String>> getExercisesRank() {
		return rankDao.getExercisesRank();
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * @date 20160821
	 * @return 
	 * 积分排行榜
	 **/
	public List<Map<String,String>> getIntegralRank() {
		return rankDao.getIntegralRank();
	}

}
