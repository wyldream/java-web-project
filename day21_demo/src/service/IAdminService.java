package service;

import entity.Admin;

public interface IAdminService {
	/**
	 * 根据用户名密码查询
	 * @param admin
	 * @return
	 */
	Admin findByNameAndPwd(Admin admin);
}
