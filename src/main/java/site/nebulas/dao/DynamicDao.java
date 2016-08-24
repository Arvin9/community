package site.nebulas.dao;

import java.util.List;

import site.nebulas.beans.Dynamic;



public interface DynamicDao {
	/**
	 * @author CaiHonghui
	 * @Date 20160824
	 * 安装添加时间降序查出10条记录
	 * */
	public List<Dynamic> getDynamicOrderByTime(Dynamic dynamic);
	/**
	 * @author CaiHonghui
	 * @Date 20160824
	 * @param Dynamic
	 * 插入一条动态记录
	 * */
	public void insertDynamic(Dynamic dynamic);	
}
