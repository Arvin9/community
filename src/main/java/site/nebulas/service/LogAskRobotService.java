package site.nebulas.service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import site.nebulas.beans.LogAskRobot;
import site.nebulas.dao.LogAskRobotDao;


@Service
public class LogAskRobotService {
	@Resource
	private LogAskRobotDao logAskRobotDao;
	
	public void insert(LogAskRobot logAskRobot){
		logAskRobotDao.insert(logAskRobot);
	}
	
	
}
