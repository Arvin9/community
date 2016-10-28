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

import site.nebulas.beans.Exam;
import site.nebulas.service.ExamService;

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
	
	@RequestMapping("getExamList")
	@ResponseBody
	public Object getExamList(Exam exam) {
		return examService.getExamList(exam);
	}

	@RequestMapping("getExam")
	@ResponseBody
	public Object getExam(Exam exam) {
		return examService.getExam(exam);
	}

	@RequestMapping("takeExam")
	public String takeExam(Model model,Exam exam){
		System.out.println(exam.getId());
		Exam tempExam = examService.getExam(exam);
		
		model.addAttribute("examList", JSON.toJSON(examService.getExamList(null)));
		return "exam";
	}
}




