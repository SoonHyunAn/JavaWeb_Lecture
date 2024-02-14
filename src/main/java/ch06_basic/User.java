package ch06_basic;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String pwd2;
	private String name;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private String message;
	private String url;

	public User() {
	}

	public User(String uid, String pwd, String name, String email, LocalDate regDate, int isDeleted) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
	}


	public User(String uid, String pwd, String message, String url) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.message = message;
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + ", isDeleted=" + isDeleted + "]";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

}
