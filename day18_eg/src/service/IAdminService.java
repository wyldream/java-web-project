package service;

import entity.Admin;
import exception.UserExistsException;

/**
 * ҵ���߼���ӿ�
 * @author weiyongle
 *
 */
public interface IAdminService {

	/**
	 * ע��
	 */
	void register(Admin admin) throws UserExistsException;
	/**
	 * ��½
	 */
	Admin login(Admin admin);
	
}
