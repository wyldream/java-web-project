package service;

import java.io.Serializable;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeService {
	
	// IOC×¢Èë
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * ²éÑ¯
	 * @param emp
	 */
	public Employee findById(Serializable id) {
		Employee emp = employeeDao.findById(id);
		return emp;
	}
}
