package site.nebulas.dao;

import java.util.Map;

import site.nebulas.beans.Exercises;


public interface ExercisesDao {
	public Exercises getExercisesById(Exercises exercises);
	
	/**
	 * @author CaiHonghui
	 * @date 20160823
	 * @version 0.3
	 * @param userAccount
	 * @return 一条exercises记录
	 * 根据用户查询,取用户没做过的题目，按照题目的难易度顺序排列,返回第一条记录
	 * */
	public Map<String,String> getExercisesByUserAccount(String userAccount);
	/**
	 * @author CaiHonghui
	 * @date 20160823
	 * @version 0.1
	 * @param 
	 * 将答题正确记录写入数据库
	 * */
	public void insertAnswerRecord(Exercises exercises);
	/**
	 * @author CaiHonghui
	 * @date 20160823
	 * @version 0.1
	 * @param exercisesId
	 * 更新答题正确数和答题数
	 * */
	public void updateAnswerCorrectValue(Exercises exercises);
	/**
	 * @author CaiHonghui
	 * @date 20160823
	 * @version 0.1
	 * @param exercisesId
	 * 更新答题数
	 * */
	public void updateAnswerValue(Exercises exercises);
}
