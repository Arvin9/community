package site.nebulas.dao;


import java.util.List;
import site.nebulas.beans.Exam;


public interface ExamDao {
	public List<Exam> getExamList(Exam exam);
	public Exam getExam(Exam exam);
}
