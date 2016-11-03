package site.nebulas.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import site.nebulas.beans.ChoiceQuestion;
import site.nebulas.beans.Exam;
import site.nebulas.beans.ExamRecord;
import site.nebulas.beans.JudgeQuestion;
import site.nebulas.beans.ProgramQuestion;
import site.nebulas.beans.Response;
import site.nebulas.service.ExamService;
import site.nebulas.util.DateUtil;

@Controller
public class ExamController {
	
	Logger log = LoggerFactory.getLogger(ExamController.class);
	
	@Resource
	private ExamService examService;
	
	/**
	 * @author CaiHonghui
	 * @date 20161027
	 *  考试页面
	 */
	@RequestMapping("exam")
	public ModelAndView exam(){
		ModelAndView modelAndView = new ModelAndView("exam");
		modelAndView.addObject("examList", JSON.toJSON(examService.getExamList(null)));
		return modelAndView;
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20161027
	 *  试题页面
	 */
	@RequestMapping("questions")
	public ModelAndView questions(){
		ModelAndView modelAndView = new ModelAndView("questions");
		return modelAndView;
	}
	/**
	 * 获取考试信息列表
	 * */
	@RequestMapping("getExamList")
	@ResponseBody
	public Object getExamList(Exam exam) {
		return examService.getExamList(exam);
	}
	/**
	 * 获取单个考试信息
	 * */
	@RequestMapping("getExam")
	@ResponseBody
	public Object getExam(Exam exam) {
		return examService.getExam(exam);
	}
	/**
	 * @author CaiHonghui
	 * @date 20161029
	 * 参加考试
	 * */
	@RequestMapping("takeExam")
	public String takeExam(Model model,Exam exam){
		Exam tempExam = examService.getExam(exam);
		if(null == tempExam){
			//不存在这场考试时,返回考试页面
			model.addAttribute("examList", JSON.toJSON(examService.getExamList(null)));
			return "exam";
		}
		String currentTime = DateUtil.getTime();
		if(DateUtil.compareTime(currentTime,tempExam.getBeginTime()) || DateUtil.compareTime(tempExam.getEndTime(),currentTime)){
			//如果当前时间小于考试开始时间或者大于考试结束时间,返回考试页面
			model.addAttribute("examList", JSON.toJSON(examService.getExamList(null)));
			return "exam";
		}
		/**
		 * 查询用户是否参加过此次考试
		 * 未参加过,则创建一条参加记录
		 * 参加过,则
		 */
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		ExamRecord examRecord = new ExamRecord();
		examRecord.setExamId(exam.getId());
		examRecord.setUserAccount(userAccount);
		ExamRecord queryExamRecord = examService.queryExamRecord(examRecord);
		if(null == queryExamRecord){
			//未参加过,则创建一条参加记录
			examRecord.setCreateTime(DateUtil.getTime());
			examService.insertExamRecord(examRecord);
			log.info("未参加过此次考试,创建一条参加记录：" + JSON.toJSONString(examRecord));
		}else{
			//参加过,则
			log.info("用户参加过此次考试");
		}
		
		//传递考试id
		model.addAttribute("examId", exam.getId());
		//传递考试结束时间
		model.addAttribute("examEndTime", tempExam.getEndTime());
		//传递选择题列表
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		choiceQuestion.setExamId(tempExam.getId());
		model.addAttribute("choiceQuestionList", JSON.toJSON(examService.getChoiceQuestionList(choiceQuestion)));
		//传递判断题列表
		JudgeQuestion judgeQuestion = new JudgeQuestion();
		judgeQuestion.setExamId(tempExam.getId());
		model.addAttribute("judgeQuestionList", JSON.toJSON(examService.getJudgeQuestionList(judgeQuestion)));
		//传递程序题列表
		ProgramQuestion programQuestion = new ProgramQuestion();
		programQuestion.setExamId(tempExam.getId());
		model.addAttribute("programQuestionList", JSON.toJSON(examService.getProgramQuestionList(programQuestion)));
		return "questions";
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20161029
	 * 获取选择题列表
	 * */
	@RequestMapping("getChoiceQuestionList")
	@ResponseBody
	public Object getChoiceQuestionList(ChoiceQuestion choiceQuestion) {
		return examService.getChoiceQuestionList(choiceQuestion);
	}
	
	/**
	 * @author CaiHonghui
	 * @date 20161103
	 * 提交答案
	 * */
	@RequestMapping("submitAnswer")
	@ResponseBody
	public Object submitAnswer(Integer examId,String choiceAnswer) {
		Response res = new Response();
		JSONArray choiceAnswerArray = JSON.parseArray(choiceAnswer);
		int choiceAnswerSize = choiceAnswerArray.size();
		int choiceScore = 0;
		for(int i=0;i<choiceAnswerSize;i++){
			Integer id = (Integer) choiceAnswerArray.getJSONObject(i).get("id");
			Integer answer = Integer.parseInt(choiceAnswerArray.getJSONObject(i).get("answer").toString());
			if(examService.verifyChoiceAnswer(id, answer)){
				choiceScore += 5; //选择题每题5分
			}
		}
		//获得当前用户名
		Subject subject = SecurityUtils.getSubject();
		String userAccount = (String)subject.getPrincipal();
		//根据examId、userAccount更新选择题分数记录
		ExamRecord examRecord = new ExamRecord();
		examRecord.setExamId(examId);
		examRecord.setUserAccount(userAccount);
		examRecord.setChoiceScore(choiceScore);
		examService.updateExamRecord(examRecord);
		res.setData(choiceAnswer);
		return res;
	}
}




