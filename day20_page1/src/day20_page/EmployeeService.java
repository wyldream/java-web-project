package day20_page;
/**
 * 业务逻辑层实现
 * 调用DAO中的方法从数据库中获取数据
 * @author weiyongle
 *
 */
public class EmployeeService implements IEmployeeService{

	//创建DAO实例
	private IEmployeeDao employeeDao = new EmployeeDao();
	public void getAll(PageBean<Employee> pb) {
		// TODO Auto-generated method stub
		try {
			employeeDao.getAll(pb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
