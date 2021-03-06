package site.nebulas.beans;

/**
 * @author Caihonghui
 * @version 0.1
 * 20160813 每日一句,喜欢与不喜欢功能
 */
public class DailySentence {
	private Integer dailySentenceId;
	private String dailySentence;
	private String dailySentenceAddTime;
	private Integer dailySentenceShowTimes;
	private String dailySentenceUrl;
	private Integer dailySentenceLike;
	private Integer dailySentenceDisLike;
	
	//hobby
	private Integer dailySentenceHobbyId;
	private String userAccount;
	private String dailySentenceHobbyAddTime;
	private int dailySentenceHobby;//1为喜欢，2位不喜欢
	public Integer getDailySentenceId() {
		return dailySentenceId;
	}
	public void setDailySentenceId(Integer dailySentenceId) {
		this.dailySentenceId = dailySentenceId;
	}
	public String getDailySentence() {
		return dailySentence;
	}
	public void setDailySentence(String dailySentence) {
		this.dailySentence = dailySentence;
	}
	public String getDailySentenceAddTime() {
		return dailySentenceAddTime;
	}
	public void setDailySentenceAddTime(String dailySentenceAddTime) {
		this.dailySentenceAddTime = dailySentenceAddTime;
	}
	public Integer getDailySentenceShowTimes() {
		return dailySentenceShowTimes;
	}
	public void setDailySentenceShowTimes(Integer dailySentenceShowTimes) {
		this.dailySentenceShowTimes = dailySentenceShowTimes;
	}
	public Integer getDailySentenceHobbyId() {
		return dailySentenceHobbyId;
	}
	public void setDailySentenceHobbyId(Integer dailySentenceHobbyId) {
		this.dailySentenceHobbyId = dailySentenceHobbyId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getDailySentenceHobbyAddTime() {
		return dailySentenceHobbyAddTime;
	}
	public void setDailySentenceHobbyAddTime(String dailySentenceHobbyAddTime) {
		this.dailySentenceHobbyAddTime = dailySentenceHobbyAddTime;
	}
	public int getDailySentenceHobby() {
		return dailySentenceHobby;
	}
	public void setDailySentenceHobby(int dailySentenceHobby) {
		this.dailySentenceHobby = dailySentenceHobby;
	}
	public String getDailySentenceUrl() {
		return dailySentenceUrl;
	}
	public void setDailySentenceUrl(String dailySentenceUrl) {
		this.dailySentenceUrl = dailySentenceUrl;
	}
	public Integer getDailySentenceLike() {
		return dailySentenceLike;
	}
	public void setDailySentenceLike(Integer dailySentenceLike) {
		this.dailySentenceLike = dailySentenceLike;
	}
	public Integer getDailySentenceDisLike() {
		return dailySentenceDisLike;
	}
	public void setDailySentenceDisLike(Integer dailySentenceDisLike) {
		this.dailySentenceDisLike = dailySentenceDisLike;
	}
	
	
	
}
