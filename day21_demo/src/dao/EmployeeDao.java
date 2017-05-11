package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;

import entity.Employee;

public class EmployeeDao implements IEmployeeDao {

	public List<Employee> getAll() {
		try {
			String sql = "select * from employee";
			List<Employee> list = JdbcUtils.getQueryRuner()//
				.query(sql, new BeanListHandler<Employee>(Employee.class));
/*			for(Employee e:list){
				System.out.println(e);
			}*/
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}