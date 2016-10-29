package site.nebulas.dao;


import java.util.List;

import site.nebulas.beans.ChoiceQuestion;
import site.nebulas.beans.Exam;


public interface ExamDao {
	public List<Exam> getExamList(Exam exam);
	public Exam getExam(Exam exam);
	
	public List<ChoiceQuestion> getChoiceQuestionList(ChoiceQuestion choiceQuestion);
}
