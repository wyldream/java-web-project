package day20_page;
/**
 * 数据访问层 接口设计
 * @author weiyongle
 *
 */
public interface IEmployeeDao {
	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Employee> pb);
	
	/**
	 * 查询总记录数
	 * @return 
	 */
	public void getTotalCount();
}
