package service;

import entity.Admin;
import exception.UserExistsException;

/**
 * ÒµÎñÂß¼­²ã½Ó¿Ú
 * @author weiyongle
 *
 */
public interface IAdminService {

	/**
	 * ×¢²á
	 */
	void register(Admin admin) throws UserExistsException;
	/**
	 * µÇÂ½
	 */
	Admin login(Admin admin);
	
}
