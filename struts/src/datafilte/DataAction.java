package datafilte;

import com.opensymphony.xwork2.ActionSupport;
/**
 *  注意：如果要想用struts的数据效验功能，必须继承ActionSupport或实现相关接口
 *  2种方式
 *  1、实现validate方法
 *  2、通过xml的方式
 * @author LBJ
 *
 */
/**
 * 关于表单中提交信息的错误 警告: Error setting expression 'user.email' with value '[Ljava.lang.String;@
 * 是因为提交到了另一个action中
 * 产生错误的几个原因
 * 1、注意提交的路径是否正确（这里提交路径错误）
 * 2、引入的xml文件是否重名
 * 如果在网上找不到的错误往往是低级的书写错误。。。
 * @author LBJ
 *
 */
public class DataAction extends ActionSupport {
	//封装请求数据
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		System.out.println(user);
		this.user = user;
	}
	
	//重写数据验证的方法,重写validate方法
/*	public void validateRegister() {//只验证特定方法
		// TODO Auto-generated method stub
		if(user.getUserName() == null || "".equals(user.getUserName())){
			super.addFieldError("userName", "用户名必须填写");
		}
		if(user.getPwd() == null || "".equals(user.getPwd())){
			super.addFieldError("pwd", "密码必须填写");
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
