package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.ChoiceQuestion;
import site.nebulas.beans.Exam;
import site.nebulas.beans.ExamRecord;
import site.nebulas.beans.JudgeQuestion;
import site.nebulas.beans.ProgramQuestion;
import site.nebulas.dao.ExamDao;
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
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161029 获取选择题列表
	 */
	public List<ChoiceQuestion> getChoiceQuestionList(ChoiceQuestion choiceQuestion){
		return examDao.getChoiceQuestionList(choiceQuestion);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161031 获取判断题列表
	 */
	public List<JudgeQuestion> getJudgeQuestionList(JudgeQuestion judgeQuestion){
		return examDao.getJudgeQuestionList(judgeQuestion);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161031 获取程序题列表
	 */
	public List<ProgramQuestion> getProgramQuestionList(ProgramQuestion programQuestion){
		return examDao.getProgramQuestionList(programQuestion);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161101  获取考试记录
	 * @param examId userAccount
	 * */
	public ExamRecord queryExamRecord(ExamRecord examRecord){
		return examDao.queryExamRecord(examRecord);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161101 插入考试记录
	 * @param examId,userAccount,createTime
	 * */
	public void insertExamRecord(ExamRecord examRecord){
		examDao.insertExamRecord(examRecord);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161101 更新考试记录
	 * @param examId,userAccount
	 * 		choiceScore,judgeScore,programScore,totalScore
	 * */
	public void updateExamRecord(ExamRecord examRecord){
		examDao.updateExamRecord(examRecord);
	}
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20161103 核对选择题答案
	 * @param 
	 * */
	public boolean verifyChoiceAnswer(Integer id,Integer answer){
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		choiceQuestion.setId(id);
		choiceQuestion = examDao.getChoiceQuestion(choiceQuestion);
		if(choiceQuestion.getResult().equals(answer)){
			return true;
		}
		return false;
	}
	
	
}
