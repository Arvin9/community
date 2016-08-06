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
	
	public List<DailySentence> getDailySentenceByParm(DailySentence dailySentence){
		return dailySentenceDao.getDailySentenceByParm(dailySentence);
	}
}
