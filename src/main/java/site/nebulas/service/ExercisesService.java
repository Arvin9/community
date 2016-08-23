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
	
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813  根据id查询一条Exercises记录
	 * 
	 * */
	public Exercises getExercisesById(Exercises exercises){
		return exercisesDao.getExercisesById(exercises);
	}
	
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813 根据用户名连表查询一条未做过的记录
	 * */
	public Map<String,String> getExercisesByUserAccount(String userAccount){
		return exercisesDao.getExercisesByUserAccount(userAccount);
	}
	/**
	 * @author CaiHonghui
	 * @since 0.1
	 * 20160813 插入答题记录
	 * */
	public void insertAnswerRecord(Exercises exercises){
		exercisesDao.insertAnswerRecord(exercises);
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20160823
	 * @version 0.1
	 * @param exercisesId
	 * 更新答题正确数和答题数
	 * */
	public void updateAnswerCorrectValue(Exercises exercises){
		exercisesDao.updateAnswerCorrectValue(exercises);
	}
	/**
	 * @author CaiHonghui
	 * @date 20160823
	 * @version 0.1
	 * @param exercisesId
	 * 更新答题数
	 * */
	public void updateAnswerValue(Exercises exercises){
		exercisesDao.updateAnswerValue(exercises);
	}
}
