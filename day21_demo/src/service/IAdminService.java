package service;

import entity.Admin;

public interface IAdminService {
	/**
	 * �����û��������ѯ
	 * @param admin
	 * @return
	 */
	Admin findByNameAndPwd(Admin admin);
}
