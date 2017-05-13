package datafilte;

import java.util.Date;

/**
 * 实体类设计
 * @author LBJ
 *
 */
public class User {
	private String userName;
	private String pwd;
	private String email;
	private String birth;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+userName+" "+pwd+" "+email+" "+birth+"]";
	}
/*	private String user;
	private String pwd;
	private String email;
	private Date birth;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [birth=" + birth + ", email=" + email + ", pwd=" + pwd
				+ ", userName=" + user + "]";
	}*/
}
