package service;

import dao.IAdminDao;
import dao.impl.AdminDao;
import entity.Admin;
import exception.UserExistsException;

/**
 * ҵ���߼���ʵ��
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
				//�û������ڣ�����ע��
				throw new UserExistsException("�û����Ѿ����ڣ�ע��ʧ��");
			}
			//�û��������ڣ���ע��
			adminDao.save(admin);
		} catch (UserExistsException e) {
			throw e;
		} catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}



}
