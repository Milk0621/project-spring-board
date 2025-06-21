package springBoard.entity;

public class Users {
	private String id;
	private String pw;
	private String name;
	private String phoneNumber;
	private String createDate;
	private String updateDate;
	private String deleteDate;
	private String userType;
	
	public Users() {

	}
	
	public Users(String id, String pw, String name, String phoneNumber, String createDate, String updateDate, String deleteDate, String userType) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
		this.userType = userType;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
