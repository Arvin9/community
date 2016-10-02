package site.nebulas.beans;

public class Attendance {
	private Integer attendanceId;//签到ID
	private String userAccount;
	private Integer attendanceCount;
	private String attendanceAddTime;
	private String attendanceDescr;
	
	
	public Integer getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	
	public Integer getAttendanceCount() {
		return attendanceCount;
	}
	public void setAttendanceCount(Integer attendanceCount) {
		this.attendanceCount = attendanceCount;
	}
	public String getAttendanceAddTime() {
		return attendanceAddTime;
	}
	public void setAttendanceAddTime(String attendanceAddTime) {
		this.attendanceAddTime = attendanceAddTime;
	}
	public String getAttendanceDescr() {
		return attendanceDescr;
	}
	public void setAttendanceDescr(String attendanceDescr) {
		this.attendanceDescr = attendanceDescr;
	}
	
	
}
