package site.nebulas.beans;
/**
 *@author CaiHOnghui
 *@since 20160811
 *登陆日志的bean
 * */
public class LogLogin {
	private Integer logLoginId;
	private String userAccount;
	private String loginTime;
	private String loginIp;
	private int loginState;
	
	public Integer getLogLoginId() {
		return logLoginId;
	}
	public void setLogLoginId(Integer logLoginId) {
		this.logLoginId = logLoginId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public int getLoginState() {
		return loginState;
	}
	public void setLoginState(int loginState) {
		this.loginState = loginState;
	}
	
	
}
