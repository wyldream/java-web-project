package a_tx;

public class DeptService {
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public void save(Dept dept){
		deptDao.save(dept);
		
		int l = 1/0;
		
		deptDao.save(dept);
	}
}
