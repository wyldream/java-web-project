package datafilte;

import com.opensymphony.xwork2.ActionSupport;
/**
 *  ע�⣺���Ҫ����struts������Ч�鹦�ܣ�����̳�ActionSupport��ʵ����ؽӿ�
 *  2�ַ�ʽ
 *  1��ʵ��validate����
 *  2��ͨ��xml�ķ�ʽ
 * @author LBJ
 *
 */
/**
 * ���ڱ����ύ��Ϣ�Ĵ��� ����: Error setting expression 'user.email' with value '[Ljava.lang.String;@
 * ����Ϊ�ύ������һ��action��
 * ��������ļ���ԭ��
 * 1��ע���ύ��·���Ƿ���ȷ�������ύ·������
 * 2�������xml�ļ��Ƿ�����
 * ����������Ҳ����Ĵ��������ǵͼ�����д���󡣡���
 * @author LBJ
 *
 */
public class DataAction extends ActionSupport {
	//��װ��������
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		System.out.println(user);
		this.user = user;
	}
	
	//��д������֤�ķ���,��дvalidate����
/*	public void validateRegister() {//ֻ��֤�ض�����
		// TODO Auto-generated method stub
		if(user.getUserName() == null || "".equals(user.getUserName())){
			super.addFieldError("userName", "�û���������д");
		}
		if(user.getPwd() == null || "".equals(user.getPwd())){
			super.addFieldError("pwd", "���������д");
		}
	}*/
	
	public String register(){
		System.out.println("AAAAAAAAAAAAAAAAAAA");
		System.out.println(user);
		return "success";
	}
	
	public String login(){
		return "success";
	}
}
