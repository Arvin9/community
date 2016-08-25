package site.nebulas.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import site.nebulas.dao.ConfigurationDao;


@Service
public class ConfigurationService {
	@Resource
	private ConfigurationDao configurationDao;
	
	public Map<String,String> getConfigurationValueByKey(String configurationKey){
		return configurationDao.getConfigurationValueByKey(configurationKey);
	}
}
