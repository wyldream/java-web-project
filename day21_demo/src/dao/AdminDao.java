package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import utils.JdbcUtils;
import entity.Admin;

public class AdminDao implements IAdminDao{
	public Admin findByNameAndPwd(Admin admin) {
		try {
			String sql = "select * from admin where userName=? and pwd=?";
			Admin ad = JdbcUtils.getQueryRuner()//
					.query(sql, 
							new BeanHandler<Admin>(Admin.class),
							admin.getUserName(),
							admin.getPwd());
		    return ad;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
/*	@Test
	public void test(){
		Admin admin = new Admin();
		try {
			String sql = "select * from admin where userName='ÕÅÈý 'and pwd=123456";
			Admin a = JdbcUtils.getQueryRuner()//
					.query(sql, 
							new BeanHandler<Admin>(Admin.class)
							);
			System.out.println(a);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
}
