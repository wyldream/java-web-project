package type;

import java.util.Date;
//���Զ���������ת��
public class User {
	// ��װ��������
	private String name;  // �����set / get���Բ��ø�
	private String pwd;
	private int age;
	private Date birth;
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public int getAge() {
		return age;
	}
	public Date getBirth() {
		return birth;
	}
}
