package site.nebulas.controller;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import site.nebulas.beans.ChoiceQuestion;
import site.nebulas.beans.Exam;
import site.nebulas.service.ExamService;
import site.nebulas.util.DateUtil;

@Controller
public class ExamController {
	
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
		System.out.println(exam.getId());
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
		
		model.addAttribute("choiceQuestionList", JSON.toJSON(examService.getChoiceQuestionList(null)));
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
}




