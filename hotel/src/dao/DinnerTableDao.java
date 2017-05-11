package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import entity.DinnerTable;
/**
 * 遇到的内存溢出错误是因为在两个类内互相创建了对方的对象
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
			//ordinal返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。 
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
		//错误原因，敲错了一个字母tableStatus tableStatue ，sql语句一定要先测试通过再写
		String sql = "select * from dinnerTable where tableStatue=?";
/*		int status = -1;
		 //判断		ts.ordinal()
		if (ts == TableStatus.Free) {
			status = 0;   // 未预定状态
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
