package site.nebulas.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.Attendance;
import site.nebulas.dao.AttendanceDao;
import site.nebulas.util.DateUtil;

@Service
public class AttendanceService {
	@Resource
	private AttendanceDao attendanceDao;
	
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 
	 * */
	public List<Attendance> queryByParam(Attendance attendance){
		return attendanceDao.queryByParam(attendance);
	}
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 根据日期和用户查询一条签到记录
	 * */
	public Attendance getByAddTime(Attendance attendance){
		return attendanceDao.getByAddTime(attendance);
	}
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 插入一条签到记录
	 * */
	public void insert(Attendance attendance){
		attendanceDao.insert(attendance);
	}
	
	/**
	 * @author Honghui
	 * @Date 20161002
	 * 执行签到动作
	 * */
	public boolean checkIn(Attendance attendance){
		if(null != attendanceDao.getByAddTime(attendance)){
			//当前用户今天已经签到,返回失败
			return false;
		}
		//获取前一天的签到记录
		attendance.setAttendanceAddTime(DateUtil.getDate(-1));
		Attendance yesterday = attendanceDao.getByAddTime(attendance);
		if(null == yesterday){
			//当没有前一天的签到记录时,连续签到次数为1
			attendance.setAttendanceCount(1);
			attendance.setAttendanceAddTime(DateUtil.getTime());
			attendanceDao.insert(attendance);
		}else{
			attendance.setAttendanceCount(yesterday.getAttendanceCount() + 1);
			attendance.setAttendanceAddTime(DateUtil.getTime());
			attendanceDao.insert(attendance);
		}
		
		return true;
	}
}
