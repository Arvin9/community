package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import site.nebulas.beans.Book;
import site.nebulas.beans.Dynamic;
import site.nebulas.dao.BookDao;
import site.nebulas.dao.DynamicDao;


@Service
public class DynamicService {
	@Resource
	private DynamicDao dynamicDao;
	
	/**
	 * @author CaiHonghui
	 * @Date 20160824
	 * 安装添加时间降序查出10条记录
	 * */
	public List<Dynamic> getDynamicOrderByTime(Dynamic dynamic){
		return dynamicDao.getDynamicOrderByTime(dynamic);
	}
	/**
	 * @author CaiHonghui
	 * @Date 20160824
	 * @param Dynamic
	 * 插入一条动态记录
	 * */
	public void insertDynamic(Dynamic dynamic){
		dynamicDao.insertDynamic(dynamic);
	}	
}
