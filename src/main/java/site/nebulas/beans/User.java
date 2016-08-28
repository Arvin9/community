package site.nebulas.beans;


import java.io.Serializable;

/**
 * @author CaiHonghui
 * @since 20160808
 */
public class User implements Serializable {
    private String userId;
    private String roleId;
    private String userAccount;
    private String userMailbox;
    private String password;
    private String salt;
    private String realName;
    private String addTime;
    private Integer isLock;
    private String addMan;
    private Integer isDelete;

    public String getCredentialsSalt() {
        return userAccount + salt;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public String getAddMan() {
		return addMan;
	}

	public void setAddMan(String addMan) {
		this.addMan = addMan;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getUserMailbox() {
		return userMailbox;
	}

	public void setUserMailbox(String userMailbox) {
		this.userMailbox = userMailbox;
	}
    
    


}
