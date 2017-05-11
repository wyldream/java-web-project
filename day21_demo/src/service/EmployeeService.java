package service;

import java.util.List;

import dao.EmployeeDao;
import dao.IEmployeeDao;
import entity.Employee;

public class EmployeeService implements IEmployeeService {

	private IEmployeeDao employeeDao = new EmployeeDao();
	
	public List<Employee> getAll() {
		try {
			return employeeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}