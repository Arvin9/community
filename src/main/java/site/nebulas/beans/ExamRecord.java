package site.nebulas.beans;

public class ExamRecord {
	private Integer id;
	private Integer examId;
	private String userAccount;
	private String createTime;
	private Integer choiceScore;
	private Integer judgeScore;
	private Integer programScore;
	private Integer totalScore;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getChoiceScore() {
		return choiceScore;
	}
	public void setChoiceScore(Integer choiceScore) {
		this.choiceScore = choiceScore;
	}
	public Integer getJudgeScore() {
		return judgeScore;
	}
	public void setJudgeScore(Integer judgeScore) {
		this.judgeScore = judgeScore;
	}
	public Integer getProgramScore() {
		return programScore;
	}
	public void setProgramScore(Integer programScore) {
		this.programScore = programScore;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
}
