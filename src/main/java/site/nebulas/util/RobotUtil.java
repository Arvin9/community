package site.nebulas.util;


import com.alibaba.fastjson.JSONObject;

import site.nebulas.util.tuling.Aes;
import site.nebulas.util.tuling.Md5;
import site.nebulas.util.tuling.PostServer;


/**
 * 加密请求测试类
 * @author 图灵机器人
 *
 */
public class RobotUtil {
	
	public static String askRobot(String message){
		//图灵网站上的secret
		String secret = "be69160973833095";
		//图灵网站上的apiKey
		String apiKey = "344bc11d2ffe4b33be4f0a3ed857881c";
		//String cmd = "你会什么";//测试用例
		//待加密的json数据
		String data = "{\"key\":\""+apiKey+"\",\"info\":\""+message+"\"}";
		//获取时间戳
		String timestamp = String.valueOf(System.currentTimeMillis());
		
		//生成密钥
		String keyParam = secret+timestamp+apiKey;
		String key = Md5.MD5(keyParam);
		
		//加密
		Aes mc = new Aes(key);
		data = mc.encrypt(data);		
		
		//封装请求参数
		JSONObject json = new JSONObject();
		json.put("key", apiKey);
		json.put("timestamp", timestamp);
		json.put("data", data);
		//请求图灵api
		String result = PostServer.SendPost(json.toString(), "http://www.tuling123.com/openapi/api");
		System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		askRobot("你好");
	}
	
}