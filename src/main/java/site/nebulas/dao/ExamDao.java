package site.nebulas.dao;


import java.util.List;
import site.nebulas.beans.ChoiceQuestion;
import site.nebulas.beans.Exam;
import site.nebulas.beans.ExamRecord;
import site.nebulas.beans.JudgeQuestion;
import site.nebulas.beans.ProgramQuestion;


public interface ExamDao {
	public List<Exam> getExamList(Exam exam);
	public Exam getExam(Exam exam);
	
	/**
	 * 获取选择题列表
	 * */
	public List<ChoiceQuestion> getChoiceQuestionList(ChoiceQuestion choiceQuestion);
	/**
	 * 获取选择题
	 * */
	public ChoiceQuestion getChoiceQuestion(ChoiceQuestion choiceQuestion);
	/**
	 * 获取判断题列表
	 * */
	public List<JudgeQuestion> getJudgeQuestionList(JudgeQuestion judgeQuestion);
	/**
	 * 获取程序题列表
	 * */
	public List<ProgramQuestion> getProgramQuestionList(ProgramQuestion programQuestion);
	/**
	 * 获取考试记录
	 * @param examId userAccount
	 * */
	public ExamRecord queryExamRecord(ExamRecord examRecord);
	
	/**
	 * 插入考试记录
	 * @param examId,userAccount,createTime
	 * */
	public void insertExamRecord(ExamRecord examRecord);
	
	/**
	 * 更新考试记录
	 * @param examId,userAccount
	 * 		choiceScore,judgeScore,programScore,totalScore
	 * */
	public void updateExamRecord(ExamRecord examRecord);
}
