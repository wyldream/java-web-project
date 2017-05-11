package service;

import java.util.List;

import entity.Employee;

public interface IEmployeeService {
	/**
	 * 查询所有的员工
	 * @return
	 */
	List<Employee> getAll();
}
