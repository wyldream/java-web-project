package service;

import dao.AdminDao;
import dao.IAdminDao;
import entity.Admin;

public class AdminService implements IAdminService{
	
	// 创建dao对象
	private IAdminDao adminDao = new AdminDao();

	public Admin findByNameAndPwd(Admin admin) {
		try {
			return adminDao.findByNameAndPwd(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}