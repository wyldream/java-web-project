package dao;

import entity.Admin;
/**
 * 2�����ݷ��ʲ㣬�ӿ����
 * @author weiyongle
 *
 */
public interface IAdminDao {

    /**
     * ����
     */
	void save(Admin admin);
	/**
	 * �����û��������ѯ
	 */
	Admin findByNameAndPwd(Admin admin);
	/**
	 * ����û����Ƿ����
	 * true�Ѵ��ڣ�false������
	 */
	boolean userExists(String name);
}
