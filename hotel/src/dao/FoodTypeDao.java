package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;

import entity.FoodType;
/**
 * ��ϵģ��daoʵ��
 * @author weiyongle
 *
 */
public class FoodTypeDao implements IFoodTypeDao {

	@Override
	public void save(FoodType foodType) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO foodType(typeName) VALUES(?);";
		try {
			JdbcUtils.getQueryRunner().update(sql,foodType.getTypeName());//����Ĳ�����sql����в�ȷ�����Ǹ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType foodType) {
		// TODO Auto-generated method stub
		String sql = "update foodType set typeName=? where id=?";
		try {
			JdbcUtils.getQueryRunner().update(sql,foodType.getTypeName(),foodType.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public FoodType findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from foodType where id=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<FoodType>(FoodType.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from foodType";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		// TODO Auto-generated method stub
		String sql = "select * from foodType where typeName like ?";
		try {
			return JdbcUtils.getQueryRunner()
				.query(sql, new BeanListHandler<FoodType>(FoodType.class),"%" + typeName + "%");
			//ģ��������ѯ%�������������ַ�����_��ʾһ���ַ�
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from foodType where id=?";
		try {
			JdbcUtils.getQueryRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
