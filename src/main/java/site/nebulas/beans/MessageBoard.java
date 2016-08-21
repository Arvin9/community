package site.nebulas.beans;

public class MessageBoard {
	private Integer messageBoardId;
	private String userAccount;
	private String messageBoardContent;
	private String messageBoardAddTime;
	private Integer messageBoardSupport;
	private String messageBoardLoginIp;
	
	/**
	 * 留言板点赞信息
	 **/
	private Integer messageBoardSupportId;
	private String messageBoardSupportTime;
	private String messageBoardSupportLoginIp; //留言点赞人的ip地址
	
	public Integer getMessageBoardId() {
		return messageBoardId;
	}
	public void setMessageBoardId(Integer messageBoardId) {
		this.messageBoardId = messageBoardId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getMessageBoardContent() {
		return messageBoardContent;
	}
	public void setMessageBoardContent(String messageBoardContent) {
		this.messageBoardContent = messageBoardContent;
	}
	public String getMessageBoardAddTime() {
		return messageBoardAddTime;
	}
	public void setMessageBoardAddTime(String messageBoardAddTime) {
		this.messageBoardAddTime = messageBoardAddTime;
	}
	public Integer getMessageBoardSupport() {
		return messageBoardSupport;
	}
	public void setMessageBoardSupport(Integer messageBoardSupport) {
		this.messageBoardSupport = messageBoardSupport;
	}
	public String getMessageBoardLoginIp() {
		return messageBoardLoginIp;
	}
	public void setMessageBoardLoginIp(String messageBoardLoginIp) {
		this.messageBoardLoginIp = messageBoardLoginIp;
	}
	public Integer getMessageBoardSupportId() {
		return messageBoardSupportId;
	}
	public void setMessageBoardSupportId(Integer messageBoardSupportId) {
		this.messageBoardSupportId = messageBoardSupportId;
	}
	public String getMessageBoardSupportTime() {
		return messageBoardSupportTime;
	}
	public void setMessageBoardSupportTime(String messageBoardSupportTime) {
		this.messageBoardSupportTime = messageBoardSupportTime;
	}
	public String getMessageBoardSupportLoginIp() {
		return messageBoardSupportLoginIp;
	}
	public void setMessageBoardSupportLoginIp(String messageBoardSupportLoginIp) {
		this.messageBoardSupportLoginIp = messageBoardSupportLoginIp;
	}
	
	
}
