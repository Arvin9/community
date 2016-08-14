package site.nebulas.beans;

public class Exercises {
	private Integer exercisesId;
	private String exercisesTitle;
	private String exercisesContent;
	private String exercisesAnswer;
	private Integer exercisesCount;
	private Integer exercisesCorrectCount;
	private String exercisesHint;
	
	//答题记录
	private Integer exercisesAnswerId;
	private String userAccount;
	private String exercisesAnswerTime;
	
	public Integer getExercisesId() {
		return exercisesId;
	}
	public void setExercisesId(Integer exercisesId) {
		this.exercisesId = exercisesId;
	}
	public String getExercisesTitle() {
		return exercisesTitle;
	}
	public void setExercisesTitle(String exercisesTitle) {
		this.exercisesTitle = exercisesTitle;
	}
	public String getExercisesContent() {
		return exercisesContent;
	}
	public void setExercisesContent(String exercisesContent) {
		this.exercisesContent = exercisesContent;
	}
	public String getExercisesAnswer() {
		return exercisesAnswer;
	}
	public void setExercisesAnswer(String exercisesAnswer) {
		this.exercisesAnswer = exercisesAnswer;
	}
	public Integer getExercisesCount() {
		return exercisesCount;
	}
	public void setExercisesCount(Integer exercisesCount) {
		this.exercisesCount = exercisesCount;
	}
	public Integer getExercisesCorrectCount() {
		return exercisesCorrectCount;
	}
	public void setExercisesCorrectCount(Integer exercisesCorrectCount) {
		this.exercisesCorrectCount = exercisesCorrectCount;
	}
	public Integer getExercisesAnswerId() {
		return exercisesAnswerId;
	}
	public void setExercisesAnswerId(Integer exercisesAnswerId) {
		this.exercisesAnswerId = exercisesAnswerId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getExercisesAnswerTime() {
		return exercisesAnswerTime;
	}
	public void setExercisesAnswerTime(String exercisesAnswerTime) {
		this.exercisesAnswerTime = exercisesAnswerTime;
	}
	public String getExercisesHint() {
		return exercisesHint;
	}
	public void setExercisesHint(String exercisesHint) {
		this.exercisesHint = exercisesHint;
	}
	
	
}
