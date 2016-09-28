package site.nebulas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import site.nebulas.beans.Article;
import site.nebulas.service.ArticleService;
import site.nebulas.util.DateUtil;

@Controller
public class ArticleController {
	@Resource
	ArticleService articleService;
	
	/**
	 * honghui
	 * 查询文章用于首页展示摘要列表
	 * */
	@RequestMapping("articleQueryForShow")
	@ResponseBody
	public Object articleQueryForShow(Article article){
		return articleService.queryForShow(article);
	}
	/**
	 * honghui
	 * 文章详情页面
	 * */
	@RequestMapping("articleDetail")
	public ModelAndView articleDetail(Article article){
		ModelAndView model = new ModelAndView("articleDetail");
		
		List<Article> list = articleService.queryByParam(article);
		//文章浏览
		articleService.articlePageViewIncrease(article);
		
		model.addObject("articleDetail", JSON.toJSON(list.get(0)));
		return model;
	}
	
	/**
	 * 文章点赞事件
	 * */
	@RequestMapping("articleLike")
	@ResponseBody
	public void articleLike(Article article){
		articleService.articleLikeIncrease(article);
	}
	/**
	 * 文章不喜欢事件
	 * */
	@RequestMapping("articleDisLike")
	@ResponseBody
	public void articleDisLike(Article article){
		articleService.articleDisLikeIncrease(article);
	}
	/**
	 * 获取文章详细信息
	 * */
	@RequestMapping("getArticleDetail")
	@ResponseBody
	public Object getArticleDetail(Article article){
		List<Article> list = articleService.queryByParam(article);
		return JSON.toJSON(list.get(0));
	}
}
