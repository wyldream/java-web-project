package day20_page;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;



/**
 * 数据访问层实现
 * 封装从数据库中获取数据的方法
 * @author weiyongle
 *
 */
public class EmployeeDao implements IEmployeeDao{

/*	public void getAll(PageBean<Employee> pb) {
		// TODO Auto-generated method stub
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		*//**
		 * 为了避免页数超出范围，要对当前页进行判断
		 * 当前页小于等于0时为一
		 * 大于最大页时为最大页
		 *//*
		if(pb.getCurrentPage() <= 0){
			pb.setCurrentPage(1);
		}
		if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行
		int count = pb.getPageCount();// 查询返回的行数
		
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
	    String sql = "select * from employee limit ?,?";
	    
	    try {
			QueryRunner qr = JdbcUtils.queryRunner();
			//查询出的数据
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class),index,count);
			//将查询出的数据设置到pb中
			pb.setPageData(pageData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
				
	}
    @Test
	public int getTotalCount() {
		//查询employee中有多少行
		String sql = "select count(*) from employee";
		System.out.println(1);
		try {
			// 创建QueryRunner对象
			QueryRunner qr = JdbcUtils.queryRunner();
			// 执行查询， 返回结果的第一行的第一列（结果只有一行一列）
			Long count = qr.query(sql, new ScalarHandler<Long>());
			System.out.println(count);
			return count.intValue();//以 int 形式返回此 Long 的值。
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/
	/**
	 * 用junit测试中需要注意的事情
	单元测试方法不能有参数，也不能有返回值（返回void）！测试的方法不能是静态的方法。
	 */
	public void getAll(PageBean<Employee> pb) {
		
		//2. 查询总记录数;  设置到pb对象中
		int totalCount =1 ;//= this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		
	/*	 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数*/
		 
		// 判断
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // 把当前页设置为1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
		}
		
		//1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行
		int count = pb.getPageCount();							// 查询返回的行数
		
		
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
		String sql = "select * from employee limit ?,?";
		try {
			// 得到Queryrunner对象
			QueryRunner qr = JdbcUtils.queryRunner();
			// 根据当前页，查询当前页数据(一页数据)
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index, count);
			// 设置到pb对象中
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
    @Test
	public void getTotalCount() {
		String sql = "select count(*) from employee";
		System.out.println(1);
		try {
			// 创建QueryRunner对象
			QueryRunner qr = JdbcUtils.queryRunner();
			// 执行查询， 返回结果的第一行的第一列
			System.out.println(12);
			Long count = qr.query(sql, new ScalarHandler<Long>());
			System.out.println(count);
//			return count.intValue();
			return ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}















