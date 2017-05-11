package dao;

import java.util.List;

import entity.Employee;

public interface IEmployeeDao {
	/**
	 * 查询所有的员工
	 * @return
	 */
	List<Employee> getAll();
}
