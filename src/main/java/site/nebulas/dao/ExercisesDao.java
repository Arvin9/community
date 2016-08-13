package site.nebulas.dao;

import java.util.Map;

import site.nebulas.beans.Exercises;


public interface ExercisesDao {
	public Exercises getExercisesById(Exercises exercises);
	public Map<String,String> getExercisesByUserAccount(String userAccount);
	
	public void insertAnswerRecord(Exercises exercises);
}
