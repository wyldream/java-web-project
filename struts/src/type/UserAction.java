package type;
/**
 * struts���Ĺ����Զ���ȡ���ݼ��Զ���������ת��
 * @author weiyongle
 *
 */
public class UserAction {
	 // �������ͣ�һ����get����
	private User user; 
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	// ����ע������
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
