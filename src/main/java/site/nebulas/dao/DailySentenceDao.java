package site.nebulas.dao;

import java.util.List;

import site.nebulas.beans.DailySentence;


public interface DailySentenceDao {
	public DailySentence getDailySentence();
	public List<DailySentence> getDailySentenceByParm(DailySentence dailySentence);
	
	
	/**
	 * 插入一条xx用户喜欢或不喜欢xxDailySentence的记录
	 */
	public void insertDailySentenceHobby(DailySentence dailySentence);
	/**
	 * DailySentence like or dislike 
	 */
	public void updateDailySentenceLike(DailySentence dailySentence);
	public void updateDailySentenceDisLike(DailySentence dailySentence);
}
