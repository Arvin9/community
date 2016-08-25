package site.nebulas.dao;

import java.util.Map;

public interface ConfigurationDao {
	/**
	 * @author CaiHonghui
	 * @Date 20160825
	 * 根据key关键字获取value值并返回
	 */
	public Map<String,String> getConfigurationValueByKey(String configurationKey);
}
