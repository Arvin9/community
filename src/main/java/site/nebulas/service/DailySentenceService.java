package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import site.nebulas.beans.DailySentence;
import site.nebulas.dao.DailySentenceDao;
@Service
public class DailySentenceService {
	@Resource
	private DailySentenceDao dailySentenceDao;
	/**
	 * @author CaiHonghui
	 * @version 0.2
	 * 20160813 以展示次数为升序，查出一条DailySentence
	 */
	public DailySentence getDailySentence(){
		return dailySentenceDao.getDailySentence();
	}
	
	public List<DailySentence> getDailySentenceByParm(DailySentence dailySentence){
		return dailySentenceDao.getDailySentenceByParm(dailySentence);
	}
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160813 写入一条DailySentenceHobby
	 */
	public void insertDailySentenceHobby(DailySentence dailySentence){
		dailySentenceDao.insertDailySentenceHobby(dailySentence);
	}
	/**
	 * @author CaiHonghui
	 * @version 0.2
	 * 20160813 更新dailySentenceShowTimes
	 * 20160818 多更新like值
	 */
	public void updateDailySentenceLike(DailySentence dailySentence){
		dailySentenceDao.updateDailySentenceLike(dailySentence);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.2
	 * 20160813 更新dailySentenceShowTimes
	 * 20160818 多更新like值
	 */
	public void updateDailySentenceDisLike(DailySentence dailySentence){
		dailySentenceDao.updateDailySentenceDisLike(dailySentence);
	}
}
