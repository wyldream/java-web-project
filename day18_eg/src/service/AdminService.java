package service;

import dao.IAdminDao;
import dao.impl.AdminDao;
import entity.Admin;
import exception.UserExistsException;

/**
 * 业务逻辑层实现
 * @author weiyongle
 *
 */
public class AdminService implements IAdminService{

	private IAdminDao adminDao = new AdminDao();
	public Admin login(Admin admin) {
		try {
			return adminDao.findByNameAndPwd(admin);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	public void register(Admin admin) throws UserExistsException {
		try {
			boolean flag = adminDao.userExists(admin.getUserName());
			if(flag){
				//用户名存在，不可注册
				throw new UserExistsException("用户名已经存在，注册失败");
			}
			//用户名不存在，可注册
			adminDao.save(admin);
		} catch (UserExistsException e) {
			throw e;
		} catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}



}
