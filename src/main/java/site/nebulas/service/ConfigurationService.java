package site.nebulas.service;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.dao.ConfigurationDao;


@Service
public class ConfigurationService {
	@Resource
	private ConfigurationDao configurationDao;
	/**
	 * @author CaiHonghui
	 * @Date 20160825
	 * 根据key关键字获取value值并返回
	 */
	public Map<String,String> getConfigurationValueByKey(String configurationKey){
		return configurationDao.getConfigurationValueByKey(configurationKey);
	}
}
