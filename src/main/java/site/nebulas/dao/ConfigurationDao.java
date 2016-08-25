package site.nebulas.dao;

import java.util.Map;

public interface ConfigurationDao {
	public Map<String,String> getConfigurationValueByKey(String configurationKey);
}
