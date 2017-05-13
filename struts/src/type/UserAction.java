package type;
/**
 * struts核心功能自动获取数据及自动进行类型转换
 * @author weiyongle
 *
 */
public class UserAction {
	 // 对象类型，一定给get方法
	private User user; 
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	// 处理注册请求
	public String register() {
		if(user!=null){
			System.out.println(user.getName());
			System.out.println(user.getPwd());
			System.out.println(user.getAge());
			System.out.println(user.getBirth());
			return "success";
		}
		
		return "success";
	}
}
