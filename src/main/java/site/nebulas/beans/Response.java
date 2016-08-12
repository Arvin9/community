package site.nebulas.beans;

/**
 * @author CaiHonghui
 * 20160812 
 * @version 0.1
 */
public class Response {
	private Integer ststus;
	private String msg;
	private Object data;
	private String hash;
	
	public Integer getStstus() {
		return ststus;
	}
	public void setStstus(Integer ststus) {
		this.ststus = ststus;
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
