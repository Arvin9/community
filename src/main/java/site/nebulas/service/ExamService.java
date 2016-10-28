package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import site.nebulas.beans.Exam;
import site.nebulas.beans.MessageBoard;
import site.nebulas.dao.ExamDao;
import site.nebulas.dao.MessageBoardDao;
@Service
public class ExamService {
	@Resource
	private ExamDao examDao;
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161027 查询所有考试信息
	 */
	public List<Exam> getExamList(Exam exam){
		return examDao.getExamList(exam);
	}
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 查询考试信息
	 */
	public Exam getExam(Exam exam){
		return examDao.getExam(exam);
	}
	
}
