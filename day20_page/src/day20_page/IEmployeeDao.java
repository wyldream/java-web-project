package day20_page;
/**
 * ���ݷ��ʲ� �ӿ����
 * @author weiyongle
 *
 */
public interface IEmployeeDao {
	/**
	 * ��ҳ��ѯ����
	 */
	public void getAll(PageBean<Employee> pb);
	
	/**
	 * ��ѯ�ܼ�¼��
	 * @return 
	 */
	public void getTotalCount();
}
