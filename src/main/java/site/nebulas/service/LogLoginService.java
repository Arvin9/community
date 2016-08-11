package site.nebulas.service;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.LogLogin;
import site.nebulas.dao.LogLoginDao;


@Service
public class LogLoginService {
	@Resource
	private LogLoginDao logLoginDao;
	
	public List<LogLogin> QueryByParam(LogLogin logLogin) {
		return logLoginDao.QueryByParam(logLogin);
	}
	public void insert(LogLogin logLogin){
		logLoginDao.insert(logLogin);
	}
	
	
}
