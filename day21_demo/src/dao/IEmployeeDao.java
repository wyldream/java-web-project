package dao;

import java.util.List;

import entity.Employee;

public interface IEmployeeDao {
	/**
	 * ��ѯ���е�Ա��
	 * @return
	 */
	List<Employee> getAll();
}
