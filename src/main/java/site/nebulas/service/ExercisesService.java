package site.nebulas.service;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.Exercises;
import site.nebulas.dao.ExercisesDao;
@Service
public class ExercisesService {
	@Resource
	private ExercisesDao exercisesDao;
	
	public Map<String,String> getExercisesByParm(Exercises exercises){
		return exercisesDao.getExercisesByParm(exercises);
	}
}
