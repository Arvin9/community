package site.nebulas.beans;

/**
 * @author CaiHonghui
 * 20160812 
 * @version 0.1
 */
public class Response {
	private Integer ret; //返回状态
	private String msg;  //返回信息
	private Object data; //返回数据
	private String hash; //hash值
	
	
	public Integer getRet() {
		return ret;
	}
	public void setRet(Integer ret) {
		this.ret = ret;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}


	
}
