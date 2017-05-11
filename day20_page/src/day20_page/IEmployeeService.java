package day20_page;
/**
 * 业务逻辑层接口设计
 * @author weiyongle
 *
 */
public interface IEmployeeService {
	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Employee> pb);
}
