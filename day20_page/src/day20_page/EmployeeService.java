package day20_page;
/**
 * ҵ���߼���ʵ��
 * ����DAO�еķ��������ݿ��л�ȡ����
 * @author weiyongle
 *
 */
public class EmployeeService implements IEmployeeService{

	//����DAOʵ��
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
