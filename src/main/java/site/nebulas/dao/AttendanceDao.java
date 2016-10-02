package site.nebulas.dao;

import java.util.List;
import site.nebulas.beans.Attendance;

public interface AttendanceDao {
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 
	 * */
	public List<Attendance> queryByParam(Attendance attendance);
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 根据日期和用户查询一条签到记录
	 * */
	public Attendance getByAddTime(Attendance attendance);
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 插入一条签到记录
	 * */
	public void insert(Attendance attendance);	
}
