package utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ������
 * 1. ��ʼ��C3P0���ӳ�
 * 2. ����DbUtils���Ĺ��������
 * @author Jie.Yuan
 *
 */
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
	public static QueryRunner getQueryRuner(){
		// ����QueryRunner���󣬴������ӳض���
		// �ڴ���QueryRunner�����ʱ���������������Դ����
		// ��ô��ʹ��QueryRunner���󷽷���ʱ�򣬾Ͳ���Ҫ�������Ӷ���
		// ���Զ�������Դ�л�ȡ����(���ùر�����)
		return new QueryRunner(dataSource);
	}
}
