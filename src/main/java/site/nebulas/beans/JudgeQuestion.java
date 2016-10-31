package site.nebulas.beans;

public class JudgeQuestion {
	private Integer id;
	private Integer examId;
	private String question;
	private Integer answer;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
}
