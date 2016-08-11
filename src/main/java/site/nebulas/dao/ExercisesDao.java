package site.nebulas.dao;

import java.util.Map;

import site.nebulas.beans.Exercises;


public interface ExercisesDao {
	public Map<String,String> getExercisesByParm(Exercises exercises);
}
