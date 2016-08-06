package site.nebulas.dao;

import java.util.List;

import site.nebulas.beans.DailySentence;


public interface DailySentenceDao {
	public List<DailySentence> getDailySentenceByParm(DailySentence dailySentence);
}
