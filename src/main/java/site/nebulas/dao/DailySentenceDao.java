package site.nebulas.dao;

import java.util.List;

import site.nebulas.beans.DailySentence;


public interface DailySentenceDao {
	public DailySentence getDailySentence();
	public List<DailySentence> getDailySentenceByParm(DailySentence dailySentence);
	
	public void insertDailySentenceHobby(DailySentence dailySentence);
	public void updateDailySentenceShowTimes(DailySentence dailySentence);
}
