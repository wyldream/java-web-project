package dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import entity.Employee;

public class EmployeeDao {

	// ע��SessionFactory����
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * ��ѯ
	 * @param emp
	 */
	public Employee findById(Serializable id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}
}
