package day20_page;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ������
 * ��ʼ��c3p0���ӳ�
 * ����JdbcUtils���Ĺ�����
 * @author weiyongle
 *
 */
/*public class JdbcUtils {
   private static DataSource dataSource;
   static{
	   dataSource = new ComboPooledDataSource();
   }
   public static QueryRunner queryRunner(){
		// ����QueryRunner���󣬴������ӳض���
		// �ڴ���QueryRunner�����ʱ���������������Դ����
		// ��ô��ʹ��QueryRunner���󷽷���ʱ�򣬾Ͳ���Ҫ�������Ӷ���
		// ���Զ�������Դ�л�ȡ����(���ùر�����)
	   return new QueryRunner(dataSource);
   }
}*/
public class JdbcUtils {

	/**
	 *  1. ��ʼ��C3P0���ӳ�
	 */
	private static  DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * 2. ����DbUtils���Ĺ��������
	 */
	public static QueryRunner queryRunner(){
		// ����QueryRunner���󣬴������ӳض���
		// �ڴ���QueryRunner�����ʱ���������������Դ����
		// ��ô��ʹ��QueryRunner���󷽷���ʱ�򣬾Ͳ���Ҫ�������Ӷ���
		// ���Զ�������Դ�л�ȡ����(���ùر�����)
		return new QueryRunner(dataSource);
	}
}
