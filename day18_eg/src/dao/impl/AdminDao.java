package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JdbcUtil;

import com.mysql.jdbc.Connection;

import dao.IAdminDao;
import entity.Admin;

public class AdminDao implements IAdminDao{

	private Connection con;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	public void save(Admin admin) {
		String sql = "INSERT INTO admin(userName,pwd) VALUES(?,?);";
		try {
			con = (Connection) JdbcUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			// ���ò���
			pstmt.setString(1, admin.getUserName());
			pstmt.setString(2, admin.getPwd());
			// ִ�и���
			pstmt.executeUpdate();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
		
	}

	public Admin findByNameAndPwd(Admin admin) {
		String sql = "select * from admin where userName=? and pwd=?";
		Admin ad = null;
		try {
			con = (Connection) JdbcUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getUserName());
			pstmt.setString(2, admin.getPwd());
			// ִ��
			rs = pstmt.executeQuery();
			// ����
			if (rs.next()) {
				ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setUserName(rs.getString("userName"));
				ad.setPwd(rs.getString("pwd"));
			}
			return ad;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
	}

	public boolean userExists(String name) {
		String sql = "select id from admin where userName=?";
		try {
			con = (Connection) JdbcUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			// ���ò���
			pstmt.setString(1, name);
			// ִ�в�ѯ
			rs = pstmt.executeQuery();
			// �ж�
			if (rs.next()) {
				int id = rs.getInt("id");
				if (id > 0) {
					// �û����Ѿ�����
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, rs);
		}
	}

}
