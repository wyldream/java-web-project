package entity;

public class Employee {
	/**
	 * 注意：进行数据库操作时，若想将数据库中的数据封装到实体类中，
	 * 实体类中的属性名称必须与数据库中的属性名称一致
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
