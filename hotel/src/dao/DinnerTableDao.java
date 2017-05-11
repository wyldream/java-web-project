package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import entity.DinnerTable;
/**
 * �������ڴ������������Ϊ���������ڻ��ഴ���˶Է��Ķ���
 * @author weiyongle
 *
 */
public class DinnerTableDao implements IDinnerTableDao{


/*	@Override
	public List<DinnerTable> findByStatus(TableStatus ts){
		// TODO Auto-generated method stub
		try {
			String sql = "select * from dinnerTable where tableStatus=?";
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class),ts.ordinal());
			//ordinal����ö�ٳ���������������ö�������е�λ�ã����г�ʼ��������Ϊ�㣩�� 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}*/

	@Override
	public DinnerTable findById(int id) {
		// TODO Auto-generated method stub
		try{
			String sql = "select * from dinnerTable where id=?";
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<DinnerTable>(DinnerTable.class), id);
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	@Override
	public List<DinnerTable> findByStatus(TableStatus ts) {
		//����ԭ���ô���һ����ĸtableStatus tableStatue ��sql���һ��Ҫ�Ȳ���ͨ����д
		String sql = "select * from dinnerTable where tableStatue=?";
/*		int status = -1;
		 //�ж�		ts.ordinal()
		if (ts == TableStatus.Free) {
			status = 0;   // δԤ��״̬
		} else {
			status = 1;
		}
		*/
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class), ts.ordinal());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
