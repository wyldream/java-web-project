package dao;

import entity.Admin;
/**
 * 2、数据访问层，接口设计
 * @author weiyongle
 *
 */
public interface IAdminDao {

    /**
     * 保存
     */
	void save(Admin admin);
	/**
	 * 根据用户名密码查询
	 */
	Admin findByNameAndPwd(Admin admin);
	/**
	 * 检查用户名是否存在
	 * true已存在，false不存在
	 */
	boolean userExists(String name);
}
