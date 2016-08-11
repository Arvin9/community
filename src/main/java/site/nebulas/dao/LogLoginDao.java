package site.nebulas.dao;
import java.util.List;

import site.nebulas.beans.LogLogin;

public interface LogLoginDao {
	public List<LogLogin> QueryByParam(LogLogin logLogin);
	public void insert(LogLogin logLogin);
}
