package entity;

public class Employee {
	/**
	 * ע�⣺�������ݿ����ʱ�����뽫���ݿ��е����ݷ�װ��ʵ�����У�
	 * ʵ�����е��������Ʊ��������ݿ��е���������һ��
	 */
    private int id;
    private String name;
    private int dept_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+dept_id+" "+id;
	}
    
}
